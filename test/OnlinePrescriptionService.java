package com.test;


import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.prescription.OnlinePrescriptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OnlinePrescriptionServiceTest {

    private OnlinePrescriptionService prescriptionService;

    @BeforeEach
    void setUp() {
        prescriptionService = new OnlinePrescriptionService();
    }

    @Test
    void testGeneratePrescription_NoMedication() {
        Patient patient = new Inpatient("001", "John Doe", "john@example.com", "123-456-7890", "1990-01-01", "Room101");
        String prescription = prescriptionService.generatePrescription(patient);
        assertTrue(prescription.contains("No medication prescribed."));
    }
}
