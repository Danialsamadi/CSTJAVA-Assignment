package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.Prescription;
import com.alognquin.cst8288.fall24.assignment1.Constants;

import java.util.Date;

public class SurgeryTreatmentPlan implements TreatmentPlan {

	@Override
	public String createTreatmentPlan(Patient patient) {
		StringBuilder plan = new StringBuilder();
		plan.append("Surgery Treatment Plan for ").append(patient.getName()).append("\n\n");

		String riskFactor = determineRiskFactor(patient);
		String surgeryType = determineSurgeryType(patient);

		plan.append("The patient is diagnosed with a condition requiring ").append(surgeryType).append(" surgery.\n");
		plan.append("The patient is ").append(patient.getAge()).append(" years old ");
		plan.append("and falls under the ").append(patient.getLifeStage()).append(" category.\n");
		plan.append("The risk factor for this patient is ").append(riskFactor).append(".\n");

		// Create a Prescription object and populate it with surgery-related details
		Prescription prescription = new Prescription();
		prescription.setRiskFactor(riskFactor);
		prescription.setSurgeryDate(new Date());  // Assuming surgery is scheduled for today (for example)
		prescription.setFastingRequired(true);  // Set fasting required for surgery
		prescription.setFollowUpDate(new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000));  // Follow-up in 7 days

		// Attach the prescription to the patient
		patient.setPrescription(prescription);

		// Append pre-surgery instructions and details
		plan.append("Surgery scheduled for: ").append(prescription.getSurgeryDate()).append("\n");
		plan.append("Fasting required: ").append(prescription.isFastingRequired() ? "Yes" : "No").append("\n");
		plan.append("Follow-up date: ").append(prescription.getFollowUpDate()).append("\n");

		// Add pre-surgery instructions
		plan.append("\nPre-surgery instructions:\n");
		plan.append("- Fast for 12 hours before the surgery\n");
		plan.append("- Stop taking any blood-thinning medications 7 days prior to surgery\n");
		plan.append("- Arrive at the hospital 2 hours before the scheduled surgery time\n");

		return plan.toString();
	}

	private String determineRiskFactor(Patient patient) {
		if (patient.getAge() < 18) {
			return Constants.LOW;
		} else if (patient.getAge() < 60) {
			return Constants.MEDIUM;
		} else {
			return Constants.HIGH;
		}
	}

	private String determineSurgeryType(Patient patient) {
		// This is a simplified example. In a real scenario, this would be based on the specific diagnosis.
		if (patient.getAge() < 18) {
			return "minor";
		} else {
			return "major";
		}
	}
}
