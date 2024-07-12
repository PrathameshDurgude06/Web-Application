package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.entities.Patient;
import com.healthcare.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;

	public PatientController() {
		System.out.println("in patient controller");
	}

	/*
	 * Design of end point REST API to add new patient- URL-
	 * http://host:port/patients Method- POST Payload (req data)- patient DETAILS
	 * (name, disease) : patient entity Json-->Java (de-ser) Resp - @ResponseBody
	 * --patient with generated id
	 * 
	 */
	@PostMapping
	public Patient addPatient(@RequestBody Patient patient) {
		System.out.println("in add patient " + patient);
		return patientService.addNewPatient(patient);
	}

	/*
	 * Design of end point REST API to get all patients- URL-
	 * http://host:port/patients Method- GET Payload (req data)- none Resp
	 * - @ResponseBody List<Patients>
	 * 
	 */
	@GetMapping
	public List<Patient> getAllPatients() {
		System.out.println("in get all patients");
		return patientService.getAllPatients();
	}

	@GetMapping("{patientId}")
	public Patient getPatientById(@PathVariable Long patientId) {
		return patientService.getPatientById(patientId);
	}
	
	@PutMapping()
	public Patient updatePatientDetails(@RequestBody Patient patient) {
		System.out.println("in update patient details");
		return patientService.updatePatient(patient);
	}

}
