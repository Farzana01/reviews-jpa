package reviews;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private GenreRepository genreRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Genre drama = new Genre("Drama");
		genreRepo.save(drama);
		Review review1 = new Review(drama, " Sully ", "The story of Chesley Sullenberger", " Release Date: 9/9/2016",
				"Tom Hanks stars in this thrilling portrait of heroic airline pilot Chesley Sully Sullenberger, re-enacting his incredible successful emergency landing of an Airbus A320 full of passengers on the Hudson River.",
				"/images/sully.jpg");
		reviewRepo.save(review1);

		Genre musical = new Genre("Musical");
		genreRepo.save(musical);
		Review review2 = new Review(musical, " Sing ", "A musical competition", " Release Date: 12/21/2016 ",
				" Sing is exactly what you would expect if you've seen the trailer: a lighthearted and inspiring American Idol-style singing competition between animated, anthropomorphized animals.",
				"/images/sing.jpg");
		reviewRepo.save(review2);

		Genre animation = new Genre("Animation");
		genreRepo.save(animation);
		Review review3 = new Review(animation, "Up", "A journey to Paradise Falls", "Release Date: 5/29/2009",
				"Up is breathtaking in its imaginative detail and astonishing in its emotional range.",
				"/images/up.jpeg");
		reviewRepo.save(review3);

		Genre horror = new Genre("Horror");
		genreRepo.save(horror);
		Review review4 = new Review(horror, "The Conjuring",
				"Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.",
				"Release Date: 07/19/2013",
				"Well-crafted and gleefully creepy, The Conjuring ratchets up dread through a series of effective old-school scares..",
				"/images/theconjuring.jpg");
		reviewRepo.save(review4);

		Genre action = new Genre("Action");
		genreRepo.save(action);
		Review review5 = new Review(action, "Jurassic World",
				"If you're looking to sit on the edge of your seat for two hours, welcome!", "Release Date: 06/12/2015",
				"Jurassic World can't match the original for sheer inventiveness and impact, but it works in its own right as an entertaining -- and visually dazzling -- popcorn thriller.",
				"/images/action.jpg");
		reviewRepo.save(review5);

		Genre scifi = new Genre("Sci-Fi");
		genreRepo.save(scifi);
		Review review6 = new Review(scifi, "The Matrix",
				"A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
				"Release Date: 03/31/1999",
				"Thanks to the Wachowskis' imaginative vision, The Matrix is a smartly crafted combination of spectacular action and groundbreaking special effects.",
				"/images/scifi.jpg");
		reviewRepo.save(review6);

	}

}
