package com.hospital.medical_patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.dto.ApiResponse;
import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    // Create profile
    @PostMapping
    public ApiResponse<Patient> createPatient(
            @Valid @RequestBody Patient patient,
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Patient profile created successfully",
                service.createPatient(patient, userId)
        );
    }

    // View own profile
    @GetMapping("/me")
    public ApiResponse<Patient> getMyProfile(
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Patient profile fetched successfully",
                service.getByUserId(userId)
        );
    }

    // Update profile
    @PutMapping("/me")
    public ApiResponse<Patient> updateProfile(
            @Valid @RequestBody Patient patient,
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Patient profile updated successfully",
                service.updatePatient(patient, userId)
        );
    }
}
