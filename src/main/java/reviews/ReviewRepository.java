package reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepository {

	//Creating review map
	Map<Long,Review> reviewMap = new HashMap<Long, Review>();
	
	//Constructor
	public ReviewRepository() {
    
	//Constructor 
		Review review = new Review(55555, " Sully ", 
				"/images/sully.jpg", 
				" Drama ", 
				" The story of Chesley Sullenberger",
				" 9/9/2016 ", 
				" Tom Hanks stars in this thrilling portrait of heroic airline pilot Chesley Sully Sullenberger, re-enacting his incredible successful emergency landing of an Airbus A320 full of passengers on the Hudson River.");
		reviewMap.put(review.getId(),review);	
		Review review2 = new Review(67890, " Sing ", "/images/sing.jpg", " Animation ", " A musical competition", " 12/21/2016 "," Sing is exactly what you would expect if you've seen the trailer: a lighthearted and inspiring American Idol-style singing competition between animated, anthropomorphized animals.");
		reviewMap.put(review2.getId(),review2);
		Review review3 = new Review(11121, " Up ", "/images/up.jpeg", " Drama "," A journey to Paradise Falls", " 5/29/2009 "," Up is breathtaking in its imaginative detail and astonishing in its emotional range." );
		reviewMap.put(review3.getId(),review3);
	 
	}	
	//Method find all values in review map
    public Collection<Review> findAll() {
    	return reviewMap.values();
    }
    //Find one review in the map
    public Review findOne(Long id) {
    	return reviewMap.get(id);
    }
}