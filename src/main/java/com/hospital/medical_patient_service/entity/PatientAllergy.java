package com.hospital.medical_patient_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patient_allergies")
public class PatientAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allergyId;
	private Long patientId;
	
	@NotBlank(message = "Allergy name cannot be empty")
    @Size(min = 2, max = 100, message = "Allergy name must be between 2 and 100 characters")
    private String allergyName;
	
	@NotBlank(message = "Severity is required")
    private String severity;
    
	 @Size(max = 255, message = "Notes cannot exceed 255 characters")
    private String notes;

    // getters & setters
    public Long getAllergyId() {
		return allergyId;
	}
	public void setAllergyId(Long allergyId) {
		this.allergyId = allergyId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
