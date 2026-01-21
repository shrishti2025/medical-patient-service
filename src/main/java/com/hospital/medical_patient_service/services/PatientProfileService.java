package com.hospital.medical_patient_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.dto.PatientProfileResponse;
import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.entity.PatientAllergy;
import com.hospital.medical_patient_service.exception.ResourceNotFoundException;
import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.repository.PatientRepository;
import com.hospital.medical_patient_service.repository.PatientAllergyRepository;
import com.hospital.medical_patient_service.repository.MedicalHistoryRepository;

@Service
public class PatientProfileService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientAllergyRepository allergyRepository;

    @Autowired
    private MedicalHistoryRepository historyRepository;

    public PatientProfileResponse getCompleteProfile(Long userId) {

    	Patient patient = patientRepository.findByUserId(userId);
    	if (patient == null) {
    	    throw new ResourceNotFoundException("Patient not found");
    	}


        List<PatientAllergy> allergies =
                allergyRepository.findByPatientId(patient.getPatientId());

        List<MedicalHistory> history =
                (List<MedicalHistory>) historyRepository.findByPatientId(patient.getPatientId());

        return new PatientProfileResponse(patient, allergies, history);
    }
}
