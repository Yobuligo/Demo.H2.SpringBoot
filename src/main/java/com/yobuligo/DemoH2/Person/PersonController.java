package com.yobuligo.DemoH2.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	@Autowired
	IPersonRepository personRepository;

	@RequestMapping("/persons")
	public Iterable<Person> getPerson() {
		return personRepository.findAll();
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
}