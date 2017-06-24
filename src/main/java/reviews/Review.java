package reviews;

public class Review {
	
	//Instance variables
	private long id;
	private String title;
	private String imageUrl;
	private String reviewCategory;
	private String content;
	private String date;
	private String synopsis;
	
	//Constructor
	public Review(long id, String title, String imageUrl, 
			String reviewCategory, String content, String date, 
			String synopsis){
	 this.id = id;
	 this.title = title;
	 this.imageUrl = imageUrl;
	 this.reviewCategory = reviewCategory;
	 this.content = content;
	 this.date = date;
	 this.synopsis = synopsis;
	 
	 
	}
	//Getters
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getReviewCategory() {
		return reviewCategory;
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
}