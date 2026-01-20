package com.hospital.medical_patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.dto.PatientProfileResponse;
import com.hospital.medical_patient_service.services.PatientProfileService;

@RestController
@RequestMapping("/patients")
public class PatientProfileController {

    @Autowired
    private PatientProfileService service;

    @GetMapping("/profile")
    public PatientProfileResponse getPatientProfile(
            @RequestHeader("X-User-Id") Long userId) {

        return service.getCompleteProfile(userId);
    }
}
