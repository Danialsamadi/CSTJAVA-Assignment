package com.test;



import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SurgeryTreatmentPlanTest {

    private SurgeryTreatmentPlan surgeryTreatmentPlan;

    @BeforeEach
    void setUp() {
        surgeryTreatmentPlan = new SurgeryTreatmentPlan();
    }

    @Test
    void testCreateTreatmentPlan() {
        Patient patient = new Inpatient("001", "John Doe", "john@example.com", "123-456-7890", "1990-01-01", "Room101");
        String treatmentPlan = surgeryTreatmentPlan.createTreatmentPlan(patient);
        assertTrue(treatmentPlan.contains("Fasting required: Yes"));
    }
}
