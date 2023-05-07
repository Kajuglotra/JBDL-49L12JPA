package com.example.demo.service;

import com.example.demo.persondb.Person;
import com.example.demo.persondb.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person) {
        personRepository.save(person);
        return person;
    }
}
