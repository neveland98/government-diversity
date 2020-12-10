package com.talentpath.diversity.daos;

import com.talentpath.diversity.models.Gender;
import com.talentpath.diversity.models.Party;
import com.talentpath.diversity.models.Person;
import com.talentpath.diversity.models.Race;
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
        Person person1 = new Person("Joe","Aitken",1997, Gender.M, Race.WHITE, Party.INDEPENDENT);
        Person person2 = new Person("Nathaniel","Eveland",1998,Gender.M,Race.WHITE,Party.INDEPENDENT);
        Person person3 = new Person("Joe","Biden",1942,Gender.M,Race.WHITE,Party.DEMOCRAT);

        dao.addPerson(person1);
        dao.addPerson(person2);
        dao.addPerson(person3);

        List<Person> allPeople = dao.getAllPeople();

        assertEquals(3,allPeople.size());
        assertEquals(person1,allPeople.get(0));
        assertEquals(person2,allPeople.get(1));
        assertEquals(person3,allPeople.get(2));

    }
}