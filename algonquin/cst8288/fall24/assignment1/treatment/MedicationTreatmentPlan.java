package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.Prescription;

import java.util.Date;

public class MedicationTreatmentPlan implements TreatmentPlan {

    @Override
    public String createTreatmentPlan(Patient patient) {
        StringBuilder plan = new StringBuilder();
        plan.append("Medication Treatment Plan for ").append(patient.getName()).append("\n\n");

        String diseaseType = determineDiseaseType(patient);
        long duration = determineDuration(diseaseType);

        plan.append("The patient is diagnosed with ").append(diseaseType).append(".\n");
        plan.append("The patient is ").append(patient.getAge()).append(" years old ");
        plan.append("and falls under the ").append(patient.getLifeStage()).append(" category.\n");
        plan.append("Recommended treatment duration: ").append(duration).append(" days.\n");

        // Create a Prescription object and populate it with medication details
        Prescription prescription = new Prescription();
        prescription.setMedicationName("Amoxicillin"); // Example medication
        prescription.setDailyDosageCount(2); // 2 times per day
        prescription.setDuration(duration); // Duration calculated based on disease type
        prescription.setDiseaseType(diseaseType);
        prescription.setFollowUpDate(new Date(System.currentTimeMillis() + duration * 24L * 60 * 60 * 1000));  // Follow-up after treatment duration

        // Attach the prescription to the patient
        patient.setPrescription(prescription);

        // Append medication details to the plan
        plan.append("Prescribed medication: ").append(prescription.getMedicationName()).append("\n");
        plan.append("Dosage: ").append(prescription.getDailyDosageCount()).append(" times per day\n");
        plan.append("Duration: ").append(prescription.getDuration()).append(" days\n");
        plan.append("Follow-up date: ").append(prescription.getFollowUpDate()).append("\n");

        return plan.toString();
    }

    private String determineDiseaseType(Patient patient) {
        if (patient.getAge() < 12) {
            return "Acute Disease";
        } else if (patient.getAge() < 50) {
            return "Infection Disease";
        } else {
            return "Chronic Disease";
        }
    }

    private long determineDuration(String diseaseType) {
        switch (diseaseType) {
            case "Acute Disease":
                return 7;
            case "Infection Disease":
                return 14;
            case "Chronic Disease":
                return 30;
            default:
                return 7;
        }
    }
}
