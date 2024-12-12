import java.util.ArrayList;
import java.util.Date;

public class AppointmentSystem {
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static boolean bookAppointment(String userId, String clinicName,
            String doctorName, Date appointmentDate) {
        Appointment newAppointment = new Appointment(userId, clinicName, doctorName, appointmentDate);
        appointments.add(newAppointment);
        System.out.println("Appointment booked successfully!");
        return true;
    }

    public static boolean cancelAppointment(String userId, Date appointmentDate) {
        for (Appointment appointment : appointments) {
            if (appointment.getUserId().equals(userId) &&
                    appointment.appointmentDate.equals(appointmentDate) &&
                    !appointment.isPaid()) {

                appointments.remove(appointment);
                System.out.println("Appointment cancelled successfully!");
                return true;
            }
        }
        System.out.println("Appointment not found or cannot be cancelled!");
        return false;
    }
}