package com.alognquin.cst8288.fall24.assignment1;

import java.io.IOException;
import java.io.FileWriter;
import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.patient.Outpatient;
import com.algonquin.cst8288.fall24.assignment1.management.PatientManagement;
import com.algonquin.cst8288.fall24.assignment1.prescription.OnlinePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrintablePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrescriptionService;

public class Physician {
	public static void main(String[] args) throws IOException {
		// Create two patient instances
		Patient patient1 = new Inpatient("001", "Salim Halavani", "Salim238@example.com", "123-456-7890", "1990-01-01", "Room101");
		Patient patient2 = new Outpatient("002", "Jay parmar", "jayp@example.com", "123-456-7891", "1985-05-05", "2022-02-01");

		PatientManagement management = new PatientManagement();

		// Create treatment plans
		management.createTreatmentPlan(patient1);
		management.createTreatmentPlan(patient2);


		// Generate prescriptions
		PrescriptionService onlineService = new OnlinePrescriptionService();
		PrescriptionService printableService = new PrintablePrescriptionService();

		// Generate and save online prescriptions
		saveToFile(patient1.getName() + "_prescription.html", onlineService.generatePrescription(patient1));
		saveToFile(patient2.getName() + "_prescription.html", onlineService.generatePrescription(patient2));


		// Generate and save printable prescriptions
		saveToFile(patient1.getName() + "_prescription.txt", printableService.generatePrescription(patient1));
		saveToFile(patient2.getName() + "_prescription.txt", printableService.generatePrescription(patient2));

	}

	private static void saveToFile(String fileName, String content) throws IOException {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write(content);
		}
	}
}