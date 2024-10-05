package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

public class PrintablePrescriptionService implements PrescriptionService {

	@Override
	public String generatePrescription(Patient patient) {
		StringBuilder text = new StringBuilder();
		text.append("Prescription for ").append(patient.getName()).append("\n");
		text.append("Date of Birth: ").append(patient.getDateOfBirth()).append("\n\n");
		text.append("Diagnosis: ").append(patient.getPlannedTreatment()).append("\n\n");
		text.append("Rx:\n");

		// Add medication details from the patient's prescription
		if (patient.getPrescription() != null) {
			text.append("Medication: ").append(patient.getPrescription().getMedicationName()).append("\n");
			text.append("Dosage: ").append(patient.getPrescription().getDailyDosageCount()).append(" times/day\n");
			text.append("Duration: ").append(patient.getPrescription().getDuration()).append(" days\n");
		} else {
			text.append("No medication prescribed.\n");
		}

		return text.toString();
	}
}