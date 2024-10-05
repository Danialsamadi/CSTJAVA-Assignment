package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

public class OnlinePrescriptionService implements PrescriptionService {

	@Override
	public String generatePrescription(Patient patient) {
		StringBuilder html = new StringBuilder();
		html.append("<html><body>");
		html.append("<h1>Prescription for ").append(patient.getName()).append("</h1>");
		html.append("<p>Date of Birth: ").append(patient.getDateOfBirth()).append("</p>");
		html.append("<p>Diagnosis: ").append(patient.getPlannedTreatment()).append("</p>");
		html.append("<h2>Rx:</h2>");

		if (patient.getPrescription() != null) {
			html.append("<p>Medication: ").append(patient.getPrescription().getMedicationName()).append("</p>");
			html.append("<p>Dosage: ").append(patient.getPrescription().getDailyDosageCount()).append(" times/day</p>");
			html.append("<p>Duration: ").append(patient.getPrescription().getDuration()).append(" days</p>");
		} else {
			html.append("<p>No medication prescribed.</p>");
		}

		html.append("</body></html>");
		return html.toString();
	}

}