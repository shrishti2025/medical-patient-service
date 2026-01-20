package com.hospital.medical_patient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.medical_patient_service.entity.PatientAllergy;
import com.hospital.medical_patient_service.services.PatientAllergyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients/allergies")
public class PatientAllergyController {

    @Autowired
    private PatientAllergyService service;

    @PostMapping
    public PatientAllergy addAllergy(
    		@Valid
            @RequestBody PatientAllergy allergy,
            @RequestHeader("X-User-Id") Long userId) {

        // patient_id will be fetched using userId in real flow
        return service.addAllergy(allergy, userId);
    }

    @GetMapping
    public List<PatientAllergy> getAllergies(
            @RequestHeader("X-User-Id") Long userId) {

        return service.getAllergies(userId);
    }
}
