package com.hospital.medical_patient_service.dto;

import java.util.List;

import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.entity.PatientAllergy;
import com.hospital.medical_patient_service.entity.MedicalHistory;

public class PatientProfileResponse {

    private Patient patient;
    private List<PatientAllergy> allergies;
    private List<MedicalHistory> medicalHistory;

    public PatientProfileResponse(Patient patient,
                                  List<PatientAllergy> allergies,
                                  List<MedicalHistory> medicalHistory) {
        this.patient = patient;
        this.allergies = allergies;
        this.medicalHistory = medicalHistory;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<PatientAllergy> getAllergies() {
        return allergies;
    }

    public List<MedicalHistory> getMedicalHistory() {
        return medicalHistory;
    }
}
