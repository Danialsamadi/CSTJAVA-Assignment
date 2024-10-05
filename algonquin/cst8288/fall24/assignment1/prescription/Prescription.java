package com.algonquin.cst8288.fall24.assignment1.prescription;

import java.util.Date;

public class Prescription {
	private long dailyDosageCount;
	private long duration;
	private String diseaseType;
	private Date surgeryDate;
	private String riskFactor;
	private boolean isFastingRequired;
	private Date followUpDate;
	private String medicationName;

	// Constructor
	public Prescription() {
		// You can initialize any default values here if necessary
	}

	// Getters and setters for all fields
	public long getDailyDosageCount() {
		return dailyDosageCount;
	}

	public void setDailyDosageCount(long dailyDosageCount) {
		this.dailyDosageCount = dailyDosageCount;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}

	public String getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(String riskFactor) {
		this.riskFactor = riskFactor;
	}

	public boolean isFastingRequired() {
		return isFastingRequired;
	}

	public void setFastingRequired(boolean fastingRequired) {
		isFastingRequired = fastingRequired;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	// Method to calculate the days until the follow-up date
	public long getFollowUpDays() {
		return (followUpDate.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
	}
}
