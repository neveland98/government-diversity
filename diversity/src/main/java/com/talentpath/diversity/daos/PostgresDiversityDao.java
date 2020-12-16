package com.talentpath.diversity.daos;


import com.talentpath.diversity.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

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
        return template.query("SELECT * FROM \"people\" ORDER BY \"id\" ASC;",new PersonMapper());
    }

    @Override
    public List<Term> getAllTerms() {
        return template.query("SELECT * FROM \"terms\" t, \"people\" p WHERE t.\"personId\"=p.\"id\" ORDER BY \"termStart\" ASC, \"termEnd\" ASC, \"name\" ASC;",new TermMapper());
    }

    @Override
    public Person addPerson(Person toAdd) {
        return template.queryForObject("INSERT INTO \"people\" (\"name\",\"birthYear\",\"gender\",\"race\") " +
                "VALUES ('"+toAdd.getName()+"','"+ toAdd.getBirthYear() +"','"+ toAdd.getGender() +"','"+ toAdd.getRace() +"') RETURNING *;",new PersonMapper());
    }

    @Override
    public Term addTerm(Term toAdd) {
        Integer termId =  template.queryForObject("INSERT INTO \"terms\" (\"personId\",\"termStart\",\"termEnd\",\"region\",\"position\",\"party\",\"year\")" +
                " VALUES ('"+ toAdd.getPerson().getId() +"','"+ toAdd.getTermStart() +"','"+ toAdd.getTermEnd() +"','"+ toAdd.getRegion() +"','"+ toAdd.getPosition() +"','"+ toAdd.getParty() +"','"+ toAdd.getYear() +"') RETURNING \"termId\";",new TermIdMapper());
        return template.queryForObject("SELECT * FROM \"terms\" t, \"people\" p WHERE t.\"termId\"='"+ termId +"' AND t.\"personId\"=p.\"id\";",new TermMapper());
    }

    private class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person toReturn = new Person();
            toReturn.setId(resultSet.getInt("id"));
            toReturn.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
            toReturn.setName(resultSet.getString("name"));
            toReturn.setRace(Race.valueOf(resultSet.getString("race").toUpperCase()));
            toReturn.setBirthYear(resultSet.getInt("birthYear"));
            return toReturn;

        }
    }

    private class TermMapper implements RowMapper<Term> {
        @Override
        public Term mapRow(ResultSet resultSet, int i) throws SQLException {
            Term toReturn = new Term();
            Person toAdd = new Person();
            toReturn.setTermId(resultSet.getInt("termId"));
            toReturn.setRegion(resultSet.getString("region"));
            toReturn.setPosition(Position.valueOf(resultSet.getString("position").toUpperCase()));
            toReturn.setTermStart(resultSet.getInt("termStart"));
            toReturn.setTermEnd(resultSet.getInt("termEnd"));
            toReturn.setParty(Party.valueOf(resultSet.getString("party").toUpperCase()));
            toReturn.setYear(resultSet.getInt("year"));

            toAdd.setId(resultSet.getInt("id"));
            toAdd.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
            toAdd.setName(resultSet.getString("name"));
            toAdd.setRace(Race.valueOf(resultSet.getString("race").toUpperCase()));
            toAdd.setBirthYear(resultSet.getInt("birthYear"));

            toReturn.setPerson(toAdd);

            return toReturn;

        }
    }

    private class TermIdMapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("termId");
        }
    }
}
