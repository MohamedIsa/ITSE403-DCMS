public class Review {
    private int rating;
    private String reviewText;
    private String userId;

    public Review(String userId, int rating, String reviewText) {
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getRating() { return rating; }
    public String getReviewText() { return reviewText; }
}