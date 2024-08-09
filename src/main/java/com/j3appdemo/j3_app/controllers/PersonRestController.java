package com.j3appdemo.j3_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.j3appdemo.j3_app.models.Person;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:8090")  // Allow requests from this origin
public class PersonRestController {
    private Map<Integer, Person> personMap = new HashMap<>();
    @PostMapping("/createPerson")
    public Person createPerson(@RequestBody Person person) {
        personMap.put(person.getIdentificationNumber(),person);
        System.out.println(personMap.get(person.getIdentificationNumber()).getFirstname());     
        return person;
    }
    @GetMapping("/getPersonByNroIdentification/{nroIdentification}")
    public Person getPersonByNroIdentification(@PathVariable Integer nroIdentification) {
        
        return personMap.get(nroIdentification);
    }

    @ModelAttribute("persons")
    public Map<Integer, Person> personsModel() {
        return personMap;
    }

    
    
}
