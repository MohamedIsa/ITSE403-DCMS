import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Clinic clinic1 = new Clinic("Smile Dental",
                new String[] { "Cleaning", "Whitening" },
                new String[] { "Dr. Smith", "Dr. Johnson" });
        Clinic clinic2 = new Clinic("Healthy Teeth",
                new String[] { "Root Canal", "Braces" },
                new String[] { "Dr. Brown", "Dr. Lee" });

        ClinicSearch.addClinic(clinic1);
        ClinicSearch.addClinic(clinic2);

        UserManagement.signUp("John", "Doe", "123456",
                "1234567890", "password123", new Date(), "Bahrain");
        UserManagement.signUp("Jane", "Smith", "654321",
                "0987654321", "mypassword", new Date(), "Bahrain");

        System.out.println("User Data:");
        System.out.println("John Doe - ID: 123456");
        System.out.println("Jane Smith - ID: 654321");
        System.out.println();

        System.out.println("Logging in as John Doe...");
        boolean loginSuccess1 = UserManagement.login("123456", "password123");
        if (loginSuccess1) {
            System.out.println("Login successful!");

            System.out.println("Searching for clinics with 'Smile'...");
            ClinicSearch.searchClinics("Smile");

            System.out.println("Booking an appointment for John Doe at Smile Dental with Dr. Smith...");
            AppointmentSystem.bookAppointment("123456", "Smile Dental", "Dr. Smith", new Date());

            System.out.println("Adding a review for Smile Dental...");
            ReviewSystem.addReview(clinic1, "123456", 5, "Excellent service and friendly staff!");

            System.out.println("Cancelling the appointment for John Doe...");
            AppointmentSystem.cancelAppointment("123456", new Date());

            System.out.println("Processing payment for John Doe...");
            Appointment appointment = new Appointment("123456", "Smile Dental", "Dr. Smith", new Date());
            PaymentSystem.processPayment(appointment, "1234567890123456");
        } else {
            System.out.println("Login failed for John Doe.");
        }
        System.out.println();

        System.out.println("Logging in as Jane Smith...");
        boolean loginSuccess2 = UserManagement.login("654321", "mypassword");
        if (loginSuccess2) {
            System.out.println("Login successful!");

            System.out.println("Searching for clinics with 'Healthy'...");
            ClinicSearch.searchClinics("Healthy");

            System.out.println("Booking an appointment for Jane Smith at Healthy Teeth with Dr. Brown...");
            AppointmentSystem.bookAppointment("654321", "Healthy Teeth", "Dr. Brown", new Date());

            System.out.println("Adding a review for Healthy Teeth...");
            ReviewSystem.addReview(clinic2, "654321", 4, "Good experience, but wait time was long.");

            System.out.println("Processing payment for Jane Smith...");
            Appointment appointment = new Appointment("654321", "Healthy Teeth", "Dr. Brown", new Date());
            PaymentSystem.processPayment(appointment, "6543210987654321");

            double avgRating1 = ReviewSystem.getAverageRating(clinic1);
            double avgRating2 = ReviewSystem.getAverageRating(clinic2);
            System.out.println("Average Rating for " + clinic1.getClinicName() + ": " + avgRating1);
            System.out.println("Average Rating for " + clinic2.getClinicName() + ": " + avgRating2);
        } else {
            System.out.println("Login failed for Jane Smith.");
        }
    }
}