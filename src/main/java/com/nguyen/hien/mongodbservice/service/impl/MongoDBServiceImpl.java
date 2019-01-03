package com.nguyen.hien.mongodbservice.service.impl;

import com.nguyen.hien.mongodbservice.entity.Experience;
import com.nguyen.hien.mongodbservice.repository.ExperienceRepository;
import com.nguyen.hien.mongodbservice.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDBServiceImpl implements MongoDBService{

    private ExperienceRepository experienceRepository;

    @Autowired
    MongoDBServiceImpl(ExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> getExperience(){
        return experienceRepository.findAll();
    }

}
