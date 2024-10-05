package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

public interface PrescriptionService {
    String generatePrescription(Patient patient);
}