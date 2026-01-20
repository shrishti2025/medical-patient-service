package com.hospital.medical_patient_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.entity.PatientAllergy;
import com.hospital.medical_patient_service.repository.PatientAllergyRepository;

@Service
public class PatientAllergyService {

    @Autowired
    private PatientAllergyRepository repo;

    public PatientAllergy addAllergy(PatientAllergy allergy, Long patientId) {
        allergy.setPatientId(patientId);
        return repo.save(allergy);
    }

    public List<PatientAllergy> getAllergies(Long patientId) {
        return repo.findByPatientId(patientId);
    }
}
