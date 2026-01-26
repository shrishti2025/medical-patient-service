package com.hospital.medical_patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.dto.ApiResponse;
import com.hospital.medical_patient_service.dto.PatientProfileResponse;
import com.hospital.medical_patient_service.services.PatientProfileService;

@RestController
@RequestMapping("/patients/profile")
public class PatientProfileController {

    @Autowired
    private PatientProfileService service;

    @GetMapping
    public ApiResponse<PatientProfileResponse> getCompleteProfile(
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Patient complete profile fetched successfully",
                service.getCompleteProfile(userId)
        );
    }
}
