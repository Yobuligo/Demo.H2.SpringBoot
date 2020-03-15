package com.yobuligo.DemoH2.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

	@Autowired
	PatientRepository patientRepository;

	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	@RequestMapping("/patients")
	public Iterable<Patient> getAll() {
		return patientRepository.findAll();
	}
}
