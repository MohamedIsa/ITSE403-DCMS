import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicSearchTest {

    @BeforeEach
    public void setUp() {

        ClinicSearch.getAllClinics().clear();
    }

    @Test
    public void testAddClinic() {

        Clinic clinic = new Clinic("Health Clinic", new String[] { "Dental", "Pediatrics" },
                new String[] { "Dr. Smith", "Dr. Brown" });

        ClinicSearch.addClinic(clinic);

        assertEquals(1, ClinicSearch.getAllClinics().size(), "The clinic list should contain one clinic after adding.");
        assertEquals("Health Clinic", ClinicSearch.getAllClinics().get(0).getClinicName(),
                "The added clinic name should match.");
    }

    @Test
    public void testSearchClinics_Found() {

        ClinicSearch.addClinic(new Clinic("Health Clinic", new String[] { "Dental" }, new String[] { "Dr. Smith" }));
        ClinicSearch
                .addClinic(new Clinic("Wellness Center", new String[] { "Cardiology" }, new String[] { "Dr. Taylor" }));

        ArrayList<Clinic> results = ClinicSearch.searchClinics("Health");

        assertEquals(1, results.size(), "Only one clinic should match the search term 'Health'.");
        assertEquals("Health Clinic", results.get(0).getClinicName(),
                "The matching clinic name should be 'Health Clinic'.");
    }

    @Test
    public void testSearchClinics_NotFound() {

        ClinicSearch.addClinic(new Clinic("Health Clinic", new String[] { "Dental" }, new String[] { "Dr. Smith" }));

        ArrayList<Clinic> results = ClinicSearch.searchClinics("Wellness");

        assertTrue(results.isEmpty(), "No clinics should match the search term 'Wellness'.");
    }

    @Test
    public void testGetAllClinics() {

        ClinicSearch.addClinic(new Clinic("Health Clinic", new String[] { "Dental" }, new String[] { "Dr. Smith" }));
        ClinicSearch
                .addClinic(new Clinic("Wellness Center", new String[] { "Cardiology" }, new String[] { "Dr. Taylor" }));

        ArrayList<Clinic> allClinics = ClinicSearch.getAllClinics();

        assertEquals(2, allClinics.size(), "The clinic list should contain two clinics.");
    }
}
