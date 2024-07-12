package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.entities.Patient;
import com.healthcare.repository.PatientRepository;
@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient addNewPatient(Patient patient) {
	
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(Long patientId) {
		Optional<Patient> optional = patientRepository.findById(patientId);
		return optional.orElseThrow(()->new ResourceNotFoundException("Invalid category Id"));
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// update patient
		
		return patientRepository.save(patient);
	}

}
