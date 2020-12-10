package com.talentpath.diversity.services;

import com.talentpath.diversity.daos.DiversityDao;
import com.talentpath.diversity.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityService {

    DiversityDao dao;

    @Autowired
    public DiversityService(DiversityDao dao) {this.dao = dao;}


    public List<Person> getAllPeople() {return dao.getAllPeople(); }
}
