import java.util.ArrayList;

public class ClinicSearch {
    private static ArrayList<Clinic> clinics = new ArrayList<>();

    public static void addClinic(Clinic clinic) {
        clinics.add(clinic);
    }

    public static ArrayList<Clinic> searchClinics(String searchTerm) {
        ArrayList<Clinic> results = new ArrayList<>();
        for (Clinic clinic : clinics) {
            if (clinic.getClinicName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(clinic);
            }
        }
        return results;
    }

    public static ArrayList<Clinic> getAllClinics() {
        return new ArrayList<>(clinics);
    }
}