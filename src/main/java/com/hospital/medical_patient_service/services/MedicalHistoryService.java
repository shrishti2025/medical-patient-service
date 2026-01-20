package com.hospital.medical_patient_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository repository;

    public MedicalHistory addHistory(MedicalHistory history, Long patientId) {
        history.setPatientId(patientId);
        return repository.save(history);
    }

    public List<MedicalHistory> getHistory(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
