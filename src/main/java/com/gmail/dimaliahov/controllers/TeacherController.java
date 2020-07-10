package com.gmail.dimaliahov.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dimaliahov.model.Teacher;
import com.gmail.dimaliahov.repository.TeacherRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;


@RestController
public class TeacherController {

    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController (TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping("jsonT")
    public void json (){
        //записали json дані з ресурсів
        URL url =  this.getClass().getClassLoader().getResource("teacher.json");
        if (url != null){
            File jsonFile = new File(url.getFile());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Teacher> teachers= objectMapper.readValue(jsonFile, new TypeReference<List<Teacher>>(){});
                teacherRepository.saveAll(teachers);
                logger.info("All record saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("Url is null");
        }

    }
}
