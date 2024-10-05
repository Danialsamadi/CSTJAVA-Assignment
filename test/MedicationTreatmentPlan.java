package com.test;



import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedicationTreatmentPlanTest {

    private MedicationTreatmentPlan medicationTreatmentPlan;

    @BeforeEach
    void setUp() {
        medicationTreatmentPlan = new MedicationTreatmentPlan();
    }

    @Test
    void testCreateTreatmentPlan() {
        Patient patient = new Inpatient("001", "John Doe", "john@example.com", "123-456-7890", "1990-01-01", "Room101");
        String treatmentPlan = medicationTreatmentPlan.createTreatmentPlan(patient);
        assertTrue(treatmentPlan.contains("Prescribed medication: Amoxicillin"));
    }
}
