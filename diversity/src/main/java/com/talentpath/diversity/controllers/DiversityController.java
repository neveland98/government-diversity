package com.talentpath.diversity.controllers;


import com.talentpath.diversity.services.DiversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/diversity")
public class DiversityController {

    @Autowired
    DiversityService service;
}
