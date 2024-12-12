import java.util.Date;

public class Appointment {
    private String userId;
    private String clinicName;
    private String doctorName;
    Date appointmentDate;
    private boolean isPaid;

    public Appointment(String userId, String clinicName, String doctorName, Date appointmentDate) {
        this.userId = userId;
        this.clinicName = clinicName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.isPaid = false;
    }

    public void markAsPaid() { this.isPaid = true; }
    public boolean isPaid() { return isPaid; }
    public String getUserId() { return userId; }
}