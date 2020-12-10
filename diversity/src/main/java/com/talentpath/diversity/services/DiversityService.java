package com.talentpath.diversity.services;

import com.talentpath.diversity.daos.DiversityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiversityService {

    DiversityDao dao;

    @Autowired
    public DiversityService(DiversityDao dao) {this.dao = dao;}


}
