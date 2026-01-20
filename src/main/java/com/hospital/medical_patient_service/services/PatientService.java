package com.hospital.medical_patient_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public Patient createPatient(Patient patient, Long userId) {
        patient.setUserId(userId);
        return repo.save(patient);
    }

    public Patient getByUserId(Long userId) {
        return repo.findByUserId(userId);
    }

    public Patient updatePatient(Patient patient, Long userId) {
        Patient existing = repo.findByUserId(userId);
        patient.setPatientId(existing.getPatientId());
        patient.setUserId(userId);
        return repo.save(patient);
    }
}
