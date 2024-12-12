import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReviewSystemTest {

    private Clinic clinic;

    @BeforeEach
    public void setUp() {
        String clinicName = "City Health Clinic";
        String[] services = { "General Consultation", "Dental Care", "Orthopedics" };
        String[] availableDoctors = { "Dr. Smith", "Dr. Johnson", "Dr. Lee" };
        clinic = new Clinic(clinicName, services, availableDoctors);
    }

    @Test
    public void testValidReviewSubmissionRating1() {
        ReviewSystem.addReview(clinic, "user1", 1, "Terrible service!");
        assertEquals(1.0, ReviewSystem.getAverageRating(clinic));
    }

    @Test
    public void testValidReviewSubmissionRating5() {
        ReviewSystem.addReview(clinic, "user2", 5, "Excellent service!");
        assertEquals(3.0, ReviewSystem.getAverageRating(clinic));
    }

    @Test
    public void testInvalidRatingBelow1() {
        ReviewSystem.addReview(clinic, "user3", 0, "Not good!");
        assertEquals(3.0, ReviewSystem.getAverageRating(clinic));
    }

    @Test
    public void testInvalidRatingAbove5() {
        ReviewSystem.addReview(clinic, "user4", 6, "Very bad!");
        assertEquals(3.0, ReviewSystem.getAverageRating(clinic));
    }

    @Test
    public void testGetAverageRatingWithNoReviews() {
        Clinic emptyClinic = new Clinic("Empty Clinic", new String[] {}, new String[] {});
        assertEquals(0.0, ReviewSystem.getAverageRating(emptyClinic));
    }

    @Test
    public void testGetAverageRatingWithMultipleReviews() {
        Clinic multipleReviewsClinic = new Clinic("Multi Review Clinic", new String[] { "Cardiology", "Pediatrics" },
                new String[] { "Dr. Green", "Dr. Blue" });
        ReviewSystem.addReview(multipleReviewsClinic, "user1", 3, "Good service.");
        ReviewSystem.addReview(multipleReviewsClinic, "user2", 4, "Nice experience.");
        ReviewSystem.addReview(multipleReviewsClinic, "user3", 5, "Excellent!");
        assertEquals(4.0, ReviewSystem.getAverageRating(multipleReviewsClinic));
    }

    @Test
    public void testGetAverageRatingWithOneReview() {
        Clinic singleReviewClinic = new Clinic("Single Review Clinic", new String[] { "Dermatology" },
                new String[] { "Dr. White" });
        ReviewSystem.addReview(singleReviewClinic, "user1", 2, "Not great.");
        assertEquals(2.0, ReviewSystem.getAverageRating(singleReviewClinic));
    }

    @Test
    public void testAddingMultipleReviewsBySameUser() {
        Clinic sameUserClinic = new Clinic("Same User Clinic", new String[] { "Psychiatry" },
                new String[] { "Dr. Red" });
        ReviewSystem.addReview(sameUserClinic, "user5", 4, "Good, but could improve.");
        ReviewSystem.addReview(sameUserClinic, "user5", 3, "It was okay.");
        assertEquals(3.5, ReviewSystem.getAverageRating(sameUserClinic));
    }
}
