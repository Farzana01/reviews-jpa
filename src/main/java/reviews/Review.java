package reviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	// Instance variables
	@Id
	@GeneratedValue
	private long id;

	private String title;
	private String imageUrl;

	@ManyToOne
	private Genre genre; // Foreign key

	@ManyToMany
	private Set<Tag> tags;

	@Lob
	private String content;
	private String date;

	@Lob
	private String synopsis;

	// Constructor
	public Review(Genre genre, String title, String content, String date, String synopsis, String imageUrl,
			Tag... tags) {
		this.genre = genre;
		this.title = title;
		this.content = content;
		this.date = date;
		this.synopsis = synopsis;
		this.imageUrl = imageUrl;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	// No argument constructor required for JPA
	public Review() {
	}

	// Getters
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Genre getGenre() {
		return genre;
	}

	public Review(Genre genre, String title, String content) {
		this.genre = genre;
		this.title = title;
		this.content = content;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void remove(Tag toDelete) {
		tags.remove(toDelete);
	}

	public void add(Tag toAdd) {
		tags.add(toAdd);
	}
}
