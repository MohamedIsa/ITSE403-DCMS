
public class ReviewSystem {

    public static void addReview(Clinic clinic, String userId, int rating, String reviewText) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Must be between 1 and 5.");
            return;
        }

        Review review = new Review(userId, rating, reviewText);
        clinic.reviews.add(review);
        System.out.println("Review added successfully!");
    }

    public static double getAverageRating(Clinic clinic) {
        if (clinic.reviews.isEmpty())
            return 0;

        int totalRating = 0;
        for (Review review : clinic.reviews) {
            totalRating += review.getRating();
        }
        return (double) totalRating / clinic.reviews.size();
    }
}