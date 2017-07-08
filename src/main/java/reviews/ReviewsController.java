package reviews;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewsController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	GenreRepository genreRepo;

	@Resource
	TagRepository tagRepo;

	private Logger log = LoggerFactory.getLogger(getClass());
	// the genres in the parenthesis is the url(localhost.8080/genres)
	@RequestMapping("/genres") 
	// (Model,model) is used to connect with a unique name for thymeleaf in
	// html(ex:genresAsCollection should be in html file within thymeleaf
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
		model.addAttribute("selectedReview", reviewRepo.findOne(id));
		return "onereview";
	}

	@RequestMapping("/tags")
	public String fetchTags(@RequestParam long id, Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/oneTag")
	public String fetchOneTag(@RequestParam long id, Model model) {
		model.addAttribute("oneTag", tagRepo.findOne(id));
		return "oneTag";
	}

	@RequestMapping("/delete")
	public String deleteTag(@RequestParam long tagId, @RequestParam long reviewId) {
		Tag toDelete = tagRepo.findOne(tagId);
 		for(Review review: toDelete.getReviews()) {
 			review.remove(toDelete);
 			reviewRepo.save(review);
 		}
		
		tagRepo.delete(toDelete);
		return "redirect:/onereview?id=" + reviewId;
	}

	@RequestMapping("/createTag")
	public String createTag(@RequestParam long id, String name) {
		Tag tag = new Tag(name);
		tagRepo.save(tag);
		Review review = reviewRepo.findOne(id);
		review.add(tag);
		reviewRepo.save(review);
		return "redirect:/onereview?id=" + id;
	}

}