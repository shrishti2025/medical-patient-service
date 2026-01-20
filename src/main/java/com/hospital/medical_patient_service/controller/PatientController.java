package com.hospital.medical_patient_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.medical_patient_service.entity.Patient;
import com.hospital.medical_patient_service.services.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    // Create profile
    @PostMapping
    public Patient createPatient(
            @RequestBody Patient patient,
            @RequestHeader("X-User-Id") Long userId) {

        return service.createPatient(patient, userId);
    }

    // View own profile
    @GetMapping("/me")
    public Patient getMyProfile(
            @RequestHeader("X-User-Id") Long userId) {

        return service.getByUserId(userId);
    }

    // Update profile
    @PutMapping("/me")
    public Patient updateProfile(
            @RequestBody Patient patient,
            @RequestHeader("X-User-Id") Long userId) {

        return service.updatePatient(patient, userId);
    }
}
