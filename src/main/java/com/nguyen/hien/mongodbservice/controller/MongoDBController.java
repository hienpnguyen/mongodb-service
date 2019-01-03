package com.nguyen.hien.mongodbservice.controller;

import com.nguyen.hien.mongodbservice.entity.Experience;
import com.nguyen.hien.mongodbservice.service.MongoDBService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MongoDBController {

    private MongoDBService mongoDBService;

    @Autowired
    MongoDBController(MongoDBService mongoDBService){
        this.mongoDBService = mongoDBService;
    }

    @RequestMapping(path="/helloWorld")
    public ResponseEntity<String> helloWorld(HttpServletRequest request){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @RequestMapping(path="/experience")
    public ResponseEntity<String> getName(HttpServletRequest request){
        List<Experience> experienceList;

        JSONObject responseBody = new JSONObject();

        experienceList = mongoDBService.getExperience();

        JSONArray jsonArray = new JSONArray();

        for(Experience e : experienceList) {
            JSONObject currentExperience = new JSONObject();

            currentExperience.put("company", e.getCompany());
            currentExperience.put("startDate", e.getStartDate());
            currentExperience.put("endDate", e.getEndDate() == null ? "Present" : e.getEndDate());
            currentExperience.put("location", e.getLocation());
            currentExperience.put("position", e.getPosition());
            currentExperience.put("tasks", e.getTasks());

            jsonArray.put(currentExperience);
        }

        responseBody.put("experiences", jsonArray);

        return new ResponseEntity<>(responseBody.toString(), HttpStatus.OK);
    }

}
