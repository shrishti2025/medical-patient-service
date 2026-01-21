package com.hospital.medical_patient_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.exception.ResourceNotFoundException;
import com.hospital.medical_patient_service.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository repository;

    public MedicalHistory addHistory(MedicalHistory history, Long patientId) {
    	if (patientId == null) {
            throw new IllegalArgumentException("User ID is required");
        }

        List<MedicalHistory> existing = repository.findByPatientId(patientId);

        if (existing != null) {
            throw new IllegalArgumentException(
                "Patient profile already exists for this user"
            );
        }

        history.setPatientId(patientId);
        return repository.save(history);
    }

    public List<MedicalHistory> getHistory(Long patientId) {
    	List<MedicalHistory> patient = repository.findByPatientId(patientId);

        if (patient == null) {
            throw new ResourceNotFoundException(
                "Patient profile not found for userId: " + patientId
            );
        }
        return (List<MedicalHistory>) repository.findByPatientId(patientId);
    }
}
