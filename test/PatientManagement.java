package com.test;

import com.algonquin.cst8288.fall24.assignment1.management.PatientManagement;
import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientManagementTest {

    private PatientManagement patientManagement;

    @BeforeEach
    void setUp() {
        patientManagement = new PatientManagement();
    }

    @Test
    void testValidatePatientData_Valid() {
        Patient patient = new Inpatient("001", "Salim Halavani", "Salim238@example.com", "123-456-7890", "1990-01-01", "Room101");
        assertEquals(true, patientManagement.validatePatientData(patient));
    }

    @Test
    void testValidatePatientData_InvalidEmail() {
        Patient patient = new Inpatient("001", "John Doe", "johnexample.com", "123-456-7890", "1990-01-01", "Room101");
        assertFalse(patientManagement.validatePatientData(patient));
    }

    @Test
    void testCalculatePatientAge() {
        long age = patientManagement.calulatePatientAge("1990-01-01");
        assertEquals(34, age);
    }

    @Test
    void testDetermineLifeStage_Child() {
        String lifeStage = patientManagement.determineLifeStage(5);
        assertEquals("Children", lifeStage);
    }

    @Test
    void testDetermineLifeStage_Adult() {
        String lifeStage = patientManagement.determineLifeStage(30);
        assertEquals("Adult", lifeStage);
    }
}
