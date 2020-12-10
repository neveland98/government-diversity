package com.talentpath.diversity.daos;


import com.talentpath.diversity.models.Gender;
import com.talentpath.diversity.models.Party;
import com.talentpath.diversity.models.Person;
import com.talentpath.diversity.models.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile({"daotesting","production"})
public class PostgresDiversityDao implements DiversityDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public void reset() {
        template.update("TRUNCATE \"people\",\"terms\" RESTART IDENTITY;\n" +
                "ALTER SEQUENCE \"people_id_seq\" RESTART;\n" +
                "ALTER SEQUENCE \"terms_termId_seq\" RESTART;");
    }

    @Override
    public List<Person> getAllPeople() {
        return template.query("SELECT * FROM \"people\" SORT BY \"id\" ASC;",new PersonMapper());
    }

    @Override
    public Person addPerson(Person toAdd) {
        return template.queryForObject("INSERT INTO \"people\" (\"firstName\",\"lastName\",\"birthYear\",\"gender\",\"race\",\"party\") " +
                "VALUES ('"+ toAdd.getFirstName() +"','"+ toAdd.getLastName() +"','"+ toAdd.getBirthYear() +"','"+ toAdd.getGender() +"','"+ toAdd.getRace() +"','"+ toAdd.getParty() +"') RETURNING *;",new PersonMapper());
    }

    private class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person toReturn = new Person();
            toReturn.setId(resultSet.getInt("id"));
            toReturn.setGender(Gender.valueOf(resultSet.getString("gender")));
            toReturn.setFirstName(resultSet.getString("firstName"));
            toReturn.setLastName(resultSet.getString("lastName"));
            toReturn.setParty(Party.valueOf(resultSet.getString("party")));
            toReturn.setRace(Race.valueOf(resultSet.getString("race")));
            toReturn.setBirthYear(resultSet.getInt("birthYear"));
            return toReturn;

        }
    }
}
