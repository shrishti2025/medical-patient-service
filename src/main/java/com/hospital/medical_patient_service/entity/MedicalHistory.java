package com.hospital.medical_patient_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @Column(name = "patient_id", nullable =false)
    private Long patientId;

    
    @NotBlank(message = "Condition name is required")
    @Size(min = 2, max = 100, message = "Condition name must be between 2 and 100 characters")
    @Column(name = "condition_name")
    private String conditionName;

    @NotNull(message = "Diagnosis date is required")
    @PastOrPresent(message = "Diagnosis date cannot be in the future")
    @Column(name = "diagnosis_date")
    private String diagnosisDate;

    @Size(max = 255, message = "Notes cannot exceed 255 characters")
    private String notes;

    // getters & setters
    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(String diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
