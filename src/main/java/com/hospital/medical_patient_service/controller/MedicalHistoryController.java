package com.hospital.medical_patient_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hospital.medical_patient_service.dto.ApiResponse;
import com.hospital.medical_patient_service.entity.MedicalHistory;
import com.hospital.medical_patient_service.services.MedicalHistoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients/history")
public class MedicalHistoryController {

    @Autowired
    private MedicalHistoryService service;

    @PostMapping
    public ApiResponse<MedicalHistory> addHistory(
            @Valid @RequestBody MedicalHistory history,
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Medical history added successfully",
                service.addHistory(history, userId)	
        );
    }

    @GetMapping
    public ApiResponse<List<MedicalHistory>> getHistory(
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Medical history fetched successfully",
                service.getHistory(userId)
        );
    }
    
    @PutMapping("/{historyId}")
    public ApiResponse<MedicalHistory> updateHistory(
    		@PathVariable Long historyId,
            @Valid @RequestBody MedicalHistory history,
            @RequestHeader("X-User-Id") Long userId) {

        return ApiResponse.success(
                "Medical history updated successfully",
            service.updateHistory(historyId,history,userId)
        );
    }

}
