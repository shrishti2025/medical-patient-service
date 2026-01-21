package com.hospital.medical_patient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.dto.ApiResponse;
import com.hospital.medical_patient_service.entity.PatientAllergy;
import com.hospital.medical_patient_service.services.PatientAllergyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients/allergies")
public class PatientAllergyController {

    @Autowired
    private PatientAllergyService service;

    @PostMapping
    public ApiResponse<PatientAllergy> addAllergy(
            @Valid @RequestBody PatientAllergy allergy,
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Allergy added successfully",
                service.addAllergy(allergy, userId)
        );
    }

    @GetMapping
    public ApiResponse<List<PatientAllergy>> getAllergies(
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Allergies fetched successfully",
                service.getAllergies(userId)
        );
    }
}
