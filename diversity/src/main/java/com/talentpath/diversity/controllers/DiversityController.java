package com.talentpath.diversity.controllers;


import com.talentpath.diversity.models.Person;
import com.talentpath.diversity.services.DiversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/diversity")
public class DiversityController {

    @Autowired
    DiversityService service;

    @GetMapping("/allPeople")
    public List<Person> getAllPeople() {return service.getAllPeople();}

}
