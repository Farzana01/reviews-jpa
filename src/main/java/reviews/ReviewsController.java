package reviews;

import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
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
	
	@RequestMapping("/genres")
	public String fetchGenres(Model model) {
		model.addAttribute("genresAsCollection", genreRepo.findAll());
		return "genres";
	}
	
	@RequestMapping("/genre")
    public String fetchGenre(@RequestParam(value="id") long id, Model model) {
         model.addAttribute("genre", genreRepo.findOne(id));
         return "genre";
     }
    
/*
	@RequestMapping("/reviews")
	public String fetchReviews(Model model) {
		model.addAttribute("reviewsAsCollection", genreRepo.findAll());
		return "reviews";
	}
	*/
	
	@RequestMapping("/onereview")
    public String fetchOne(@RequestParam("id") long id, Model model) {
         model.addAttribute("selectedReview",reviewRepo.findOne(id));
         return "onereview";
     }
	
	@RequestMapping("/reviews")
	public String fetchReviews(@RequestParam("id")long id, Model model) {
		model.addAttribute("reviewsAsCollection",reviewRepo.findAll());
		return "reviews";
	}


}