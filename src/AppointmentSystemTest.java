import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentSystemTest {

    private static final String USER_ID = "user123";
    private static final String CLINIC_NAME = "Health Clinic";
    private static final String DOCTOR_NAME = "Dr. Smith";
    private static Date appointmentDate;

    @BeforeEach
    public void setUp() {

        AppointmentSystem.appointments.clear();
        appointmentDate = new Date();
    }

    @Test
    public void testBookAppointment_Success() {
        boolean result = AppointmentSystem.bookAppointment(USER_ID, CLINIC_NAME, DOCTOR_NAME, appointmentDate);
        assertTrue(result, "Booking an appointment should return true");
        assertEquals(1, AppointmentSystem.appointments.size(), "There should be one appointment in the system");
    }

    @Test
    public void testCancelAppointment_Success() {

        AppointmentSystem.bookAppointment(USER_ID, CLINIC_NAME, DOCTOR_NAME, appointmentDate);

        boolean result = AppointmentSystem.cancelAppointment(USER_ID, appointmentDate);

        assertTrue(result, "Canceling an appointment should return true");
        assertEquals(0, AppointmentSystem.appointments.size(),
                "The appointment list should be empty after cancellation");
    }

    @Test
    public void testCancelAppointment_Failure_AppointmentNotFound() {

        boolean result = AppointmentSystem.cancelAppointment(USER_ID, appointmentDate);
        assertFalse(result, "Canceling a non-existent appointment should return false");
    }

    @Test
    public void testCancelAppointment_Failure_PaidAppointment() {

        AppointmentSystem.bookAppointment(USER_ID, CLINIC_NAME, DOCTOR_NAME, appointmentDate);
        Appointment appointment = AppointmentSystem.appointments.get(0);
        appointment.markAsPaid();

        boolean result = AppointmentSystem.cancelAppointment(USER_ID, appointmentDate);

        assertFalse(result, "Canceling a paid appointment should return false");
        assertEquals(1, AppointmentSystem.appointments.size(),
                "The appointment list should still contain the paid appointment");
    }

    @Test
    public void testCancelAppointment_Failure_InvalidUserId() {

        AppointmentSystem.bookAppointment("otherUser", CLINIC_NAME, DOCTOR_NAME, appointmentDate);

        boolean result = AppointmentSystem.cancelAppointment(USER_ID, appointmentDate);

        assertFalse(result, "Canceling with an invalid userId should return false");
        assertEquals(1, AppointmentSystem.appointments.size(), "The appointment list should remain unchanged");
    }
}
