import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class PaymentSystemTest {

    @Test
    public void testProcessPayment_SuccessfulPayment() {

        Appointment appointment = new Appointment("user123", "Health Clinic", "Dr. Smith", new Date());
        String validCardNumber = "1234567812345678";

        boolean result = PaymentSystem.processPayment(appointment, validCardNumber);

        assertTrue(result, "Payment should be processed successfully.");
        assertTrue(appointment.isPaid(), "The appointment should be marked as paid.");
    }

    @Test
    public void testProcessPayment_InvalidCardNumber_TooShort() {

        Appointment appointment = new Appointment("user123", "Health Clinic", "Dr. Smith", new Date());
        String invalidCardNumber = "12345";

        boolean result = PaymentSystem.processPayment(appointment, invalidCardNumber);

        assertFalse(result, "Payment should fail due to an invalid card number.");
        assertFalse(appointment.isPaid(), "The appointment should not be marked as paid.");
    }

    @Test
    public void testProcessPayment_InvalidCardNumber_Null() {

        Appointment appointment = new Appointment("user123", "Health Clinic", "Dr. Smith", new Date());

        boolean result = PaymentSystem.processPayment(appointment, null);

        assertFalse(result, "Payment should fail due to a null card number.");
        assertFalse(appointment.isPaid(), "The appointment should not be marked as paid.");
    }

    @Test
    public void testProcessPayment_AlreadyPaidAppointment() {

        Appointment appointment = new Appointment("user123", "Health Clinic", "Dr. Smith", new Date());
        appointment.markAsPaid();
        String validCardNumber = "1234567812345678";

        boolean result = PaymentSystem.processPayment(appointment, validCardNumber);

        assertTrue(result, "Payment processing should succeed, but the appointment was already paid.");
        assertTrue(appointment.isPaid(), "The appointment should remain marked as paid.");
    }

    @Test
    public void testProcessPayment_ValidCardNumber_Whitespace() {

        Appointment appointment = new Appointment("user123", "Health Clinic", "Dr. Smith", new Date());
        String cardNumberWithSpaces = "1234 5678 1234 5678".replace(" ", "");

        boolean result = PaymentSystem.processPayment(appointment, cardNumberWithSpaces);

        assertTrue(result, "Payment should be processed successfully even if the card number initially had spaces.");
        assertTrue(appointment.isPaid(), "The appointment should be marked as paid.");
    }
}
