package com.nguyen.hien.mongodbservice.repository;

import com.nguyen.hien.mongodbservice.entity.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExperienceRepository extends MongoRepository<Experience, String>{

    List<Experience> findAll();

}
