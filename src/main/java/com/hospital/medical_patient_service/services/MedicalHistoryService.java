package com.hospital.medical_patient_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.exception.ResourceNotFoundException;
import com.hospital.medical_patient_service.repository.MedicalHistoryRepository;
import com.hospital.medical_patient_service.repository.PatientRepository;

@Service
public class MedicalHistoryService {

	@Autowired
    private MedicalHistoryRepository historyRepository;

    @Autowired
    private PatientRepository patientRepository;

    public MedicalHistory addHistory(MedicalHistory history, Long userId) {
    	Patient patient = patientRepository.findByUserId(userId);
    	if (patient == null) {
    		throw new ResourceNotFoundException("Patient not found");
        }

        history.setHistoryId(null);
        history.setPatientId(patient.getPatientId());
        return historyRepository.save(history);
    }

    public List<MedicalHistory> getHistory(Long userId) {
    	Patient patient = patientRepository.findByUserId(userId);

        if (patient == null) {
            throw new ResourceNotFoundException(
                "Patient profile not found for userId: " + userId
            );
        }
        return historyRepository.findByPatientId(patient.getPatientId());
    }
    
    
    public MedicalHistory updateHistory(Long historyId, MedicalHistory history, Long userId) {

        MedicalHistory existing =
            historyRepository.findById(historyId)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Medical history not found with id: " + historyId
                    )
                );

        Patient patient = patientRepository.findByUserId(userId);
        if (patient == null ||
            !existing.getPatientId().equals(patient.getPatientId())) {

            throw new ResourceNotFoundException(
                "Medical history not found for userId: " + userId
            );
        }

        history.setHistoryId(existing.getHistoryId());
        history.setPatientId(existing.getPatientId());

        return historyRepository.save(history);
    }


}
