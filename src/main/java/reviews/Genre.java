package reviews;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	// Instance variables
		@Id
		@GeneratedValue
		private long id;
		
		String title;
		
		@OneToMany(mappedBy="genre")
		private Set<Review> reviews;
		
		//No argument constructor required for JPA
		private Genre() {}
		
		//Constructor
		public Genre(String title ) {
			this.title = title;		
		}
		
		public long getId() {
			return id;
		}
		
		public String getTitle() {
			return title;
		}
		
		public Set<Review> getReviews() {
			return reviews;
		}
		

}