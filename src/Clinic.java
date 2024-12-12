import java.util.ArrayList;

public class Clinic {
    private String clinicName;
    private String[] services;
    private String[] availableDoctors;
    ArrayList<Review> reviews;

    public Clinic(String clinicName, String[] services, String[] availableDoctors) {
        this.clinicName = clinicName;
        this.services = services;
        this.availableDoctors = availableDoctors;
        this.reviews = new ArrayList<>();
    }

    public String getClinicName() {
        return clinicName;
    }

    public String[] getServices() {
        return services;
    }

    public String[] getAvailableDoctors() {
        return availableDoctors;
    }
}