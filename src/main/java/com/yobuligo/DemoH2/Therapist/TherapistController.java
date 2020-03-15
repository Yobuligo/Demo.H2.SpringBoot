package com.yobuligo.DemoH2.Therapist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yobuligo.DemoH2.Patient.Patient;
import com.yobuligo.DemoH2.Patient.PatientRepository;

@RestController
public class TherapistController {

	@Autowired
	TherapistRepository therapistRepository;

	@Autowired
	PatientRepository patientRepository;

	@RequestMapping("/therapists")
	public Iterable<Therapist> getAll() {
		return therapistRepository.findAll();
	}

	@PostMapping("/therapists")
	public Therapist addTherapist(@RequestBody Therapist therapist) {
		return therapistRepository.save(therapist);
	}

	@PostMapping("/therapists/{therapistId}/patients/{patientId}")
	public Patient addPatientToTherapist(@PathVariable("therapistId") Long therapistId,
			@PathVariable("patientId") Long patientId) {
		Therapist therapist = therapistRepository.findById(therapistId).orElseThrow(() -> new RuntimeException());
		Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException());
		therapist.addPatient(patient);
		therapistRepository.save(therapist);
		return patient;
	}

}
