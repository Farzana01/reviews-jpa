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

		Genre horror = new Genre("Horror");
		genreRepo.save(horror);
		Review review4 = new Review(horror, "The Blackcoat�s Daughter",
				"Two characters on distinct but intersecting paths-the movie is structured like a puzzle.",
				"Release Date: 02/16/2017",
				"Two females who suffer from troubling visions and flashbacks, and who are linked together by a boarding school in the Northeast.",
				"/images/blackcoat.jpg");
		reviewRepo.save(review4);

		// genreRepo.save(horror);
		Review review14 = new Review(horror, "Berlin Syndrome",
				"A terrifying film about the psychological toll of abusive relationships", "Release Date: 05/26/2017",
				"A passionate holiday romance leads to an obsessive relationship, when an Australian photojournalist wakes one morning in a Berlin apartment and is unable to leave.",
				"/images/berlinSyndrome.jpg");
		reviewRepo.save(review14);

		Genre action = new Genre("Action");
		genreRepo.save(action);
		Review review5 = new Review(action, "Jurassic World",
				"If you're looking to sit on the edge of your seat for two hours, welcome!", "Release Date: 06/12/2015",
				"Jurassic World can't match the original for sheer inventiveness and impact, but it works in its own right as an entertaining -- and visually dazzling -- popcorn thriller.",
				"/images/action.jpg");
		reviewRepo.save(review5);

		// genreRepo.save(action);
		Review review15 = new Review(action, "The Matrix",
				"A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers ", "Release Date: 03/31/1999",
				"The Matrix is a smartly crafted combination of spectacular action and groundbreaking special effects..",
				"/images/matrix.jpg");
		reviewRepo.save(review15);

		Genre scifi = new Genre("Sci-Fi");
		genreRepo.save(scifi);
		Review review6 = new Review(scifi, "Rogue One",
				"Rogue One: A Star Wars Story,\" an all-new epic adventure..",
				"Release Date: 12/16/2016",
				"n a time of conflict, a group of unlikely heroes band together on a mission to steal the plans to the Death Star, the Empire's ultimate weapon of destruction.",
				"/images/scifi.jpg");
		reviewRepo.save(review6);

		// genreRepo.save(scifi);
		Review review16 = new Review(scifi, "Deadpool",
				"Deadpool hunts down the man who nearly destroyed his life. .",
				"Release Date: 02/12/2016",
				"DEADPOOL tells the origin story of former Special Forces operative turned mercenary who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool.",
				"/images/deadpool.jpg");
		reviewRepo.save(review16);
		
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

	}

}
