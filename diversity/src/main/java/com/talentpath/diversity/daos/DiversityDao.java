package com.talentpath.diversity.daos;

import com.talentpath.diversity.models.Person;

import java.util.List;

public interface DiversityDao {
    List<Person> getAllPeople();

    void reset();
}
