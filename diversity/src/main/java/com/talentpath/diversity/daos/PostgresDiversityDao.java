package com.talentpath.diversity.daos;

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
