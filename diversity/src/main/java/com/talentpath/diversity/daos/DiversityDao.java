package com.talentpath.diversity.daos;

import com.talentpath.diversity.models.Person;
import com.talentpath.diversity.models.Term;

import java.util.List;

public interface DiversityDao {
    List<Person> getAllPeople();
    Person addPerson(Person toAdd);
    Term addTerm(Term toAdd);

    void reset();

    List<Term> getAllTerms();
}
