package com.talentpath.diversity.daos;

import com.talentpath.diversity.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.Part;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("daotesting")
class PostgresDiversityDaoTest {
    @Autowired
    DiversityDao dao;

    @BeforeEach
    void setUp() {
        dao.reset();
    }

    @Test
    void getAllPeople() {
        Person person1 = new Person("Joe Aitken",1997, Gender.M, Race.WHITE);
        Person person2 = new Person("Nathaniel Eveland",1998,Gender.M,Race.WHITE);
        Person person3 = new Person("Joe Biden",1942,Gender.M,Race.WHITE);

        dao.addPerson(person1);
        dao.addPerson(person2);
        dao.addPerson(person3);

        List<Person> allPeople = dao.getAllPeople();

        assertEquals(3,allPeople.size());
        assertEquals(person1,allPeople.get(0));
        assertEquals(person2,allPeople.get(1));
        assertEquals(person3,allPeople.get(2));

    }

    @Test
    void getAllTerms() {
        Person person1 = new Person("John Madden",1930,Gender.M,Race.WHITE);
        Person person2 = new Person("Joe Biden",1942,Gender.M,Race.WHITE);
        person1.setId(1);
        person2.setId(2);

        Term term1 = new Term(person1,1971,1974,"TX",Position.SENATE,Party.LIBERTARIAN,1971);
        Term term2 = new Term(person1,1975,1978,"TX",Position.SENATE,Party.LIBERTARIAN,1975);
        Term term3 = new Term(person2,2009,2013,"DC",Position.GOVERNOR, Party.DEMOCRAT,2009);

        dao.addPerson(person1);
        dao.addPerson(person2);

        dao.addTerm(term1);
        dao.addTerm(term2);
        dao.addTerm(term3);

        List<Term> allTerms = dao.getAllTerms();

        assertEquals(3,allTerms.size());
        assertEquals(term1,allTerms.get(0));
        assertEquals(term2,allTerms.get(1));
        assertEquals(term3,allTerms.get(2));

    }
}