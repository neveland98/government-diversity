package com.talentpath.diversity.daos;


import com.talentpath.diversity.models.Gender;
import com.talentpath.diversity.models.Party;
import com.talentpath.diversity.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile({"daotesting","production"})
public class PostgresDiversityDao implements DiversityDao {
    @Autowired
    private JdbcTemplate template;


}
