package com.hospital.medical_patient_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
	
	@NotNull(message = "User ID is required")
	private Long userId;
	
	@NotBlank(message = "Full name cannot be empty")
	@Size(min = 3, max = 100, message = "Full name must be between 3 and 100 characters")
    private String fullName;
	
	@NotBlank(message = "Gender is required")
    private String gender;
	
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String phone;
    
    @NotBlank(message = "Address cannot be empty")
    private String address;
    
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group")
    private String bloodGroup;
    
    @NotBlank(message = "Emergency contact is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Emergency contact must be 10 digits")
    private String emergencyContact;
    
    public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
}
