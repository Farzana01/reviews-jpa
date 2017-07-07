package reviews;

 import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsController {

	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	GenreRepository genreRepo;
	
	@Resource
	TagRepository tagRepo;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
		
	@RequestMapping("/genres")//the genres in the parenthesis is the url(localhost.8080/genres)
	//(Model,model) is used to connect with a unique name for thymeleaf in html(ex:genresAsCollection should be in html file within thymeleaf
	public String fetchGenres(Model model) {
	// you will see genresAsCollection in the thymeleaf loop (for th:each...)
		model.addAttribute("genresAsCollection", genreRepo.findAll());
		return "genres";
	}
	
	@RequestMapping("/genre")
    public String fetchGenre(@RequestParam long id, Model model) {
         model.addAttribute("genre", genreRepo.findOne(id));
         return "genre";
     }
    
	@RequestMapping("/allReviews") // endpoint
	// we can use Map instead of Model
	public String fetchReviews(Map<String, Object> model) {
		Iterable<Review> allTheReviews = reviewRepo.findAll();
		model.put("allReviewsModel", allTheReviews);
		
		for (Review currentReview : allTheReviews) {
			log.info(currentReview.toString());
		}
		return "reviewsView";
	}
	
	@RequestMapping("/onereview")
    public String fetchOne(@RequestParam("id") long id, Model model) {
         model.addAttribute("selectedReview",reviewRepo.findOne(id));
         return "onereview";
     }
	
	@RequestMapping("/deleteReview")
	public String deleteReview(@RequestParam long categoryId, @RequestParam long reviewId) {
		reviewRepo.delete(reviewId);
		return "redirect:/category?categoryId=" + categoryId;
	}
	
	@RequestMapping("/createReview")
	public String createReview(@RequestParam long Id, @RequestParam String title, @RequestParam String content) {
		Genre selected = genreRepo.findOne(Id);
		reviewRepo.save(new Review(selected, title, content));
		return "redirect:/genre?genreId=" + Id;
	}
	
	@RequestMapping("/tags")
    public String fetchTags(Model model) {
         model.addAttribute("tags", tagRepo.findAll());
         return "tags";
         }
	
	}