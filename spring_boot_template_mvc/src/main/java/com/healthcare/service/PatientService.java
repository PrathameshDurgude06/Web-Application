package com.healthcare.service;

import java.util.List;

import com.healthcare.entities.Patient;

public interface PatientService {
	
	//add new patient
	Patient addNewPatient(Patient patient);
	
	//list all patients
	List<Patient> getAllPatients();
	
	//get patient by id
	Patient getPatientById(Long patientId);
	
	//update patient details
	Patient updatePatient(Patient patient);

}
