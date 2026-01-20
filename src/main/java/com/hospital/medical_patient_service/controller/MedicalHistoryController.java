package com.hospital.medical_patient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.services.MedicalHistoryService;

@RestController
@RequestMapping("/patients/history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService service;

    @PostMapping
    public MedicalHistory addHistory(
            @RequestBody MedicalHistory history,
            @RequestHeader("X-Patient-Id") Long patientId) {

        return service.addHistory(history, patientId);
    }

    @GetMapping
    public List<MedicalHistory> getHistory(
            @RequestHeader("X-Patient-Id") Long patientId) {

        return service.getHistory(patientId);
    }
}
