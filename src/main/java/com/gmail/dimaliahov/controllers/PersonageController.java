package com.gmail.dimaliahov.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dimaliahov.model.Personage;

import com.gmail.dimaliahov.repository.PersonageRepository;
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
public class PersonageController {

    private final static Logger logger = LoggerFactory.getLogger(PersonageController.class);

    private PersonageRepository personageRepository;

    @Autowired
    public PersonageController(PersonageRepository teacherRepository){
        this.personageRepository = teacherRepository;
    }

    @RequestMapping("jsonT")
    public void json (){
        //записали json дані з ресурсів
        URL url =  this.getClass().getClassLoader().getResource("teacher.json");
        if (url != null){
            File jsonFile = new File(url.getFile());
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                List<Personage> teachers= objectMapper.readValue(jsonFile, new TypeReference<List<Personage>>(){});
                personageRepository.saveAll(teachers);
                logger.info("All record saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("Url is null");
        }

    }

    //Написать новий JSON адміна, вчителя, студента.

    // урл для створення студента
    // урл для редагування
    // урл для видалення
    // (особистий кабінет) урл де можно вибрати викладача (+ бачить ціну за час)
    // Додати поле де вказана ціна за час
    // Після вибору викладача, має бути вибір доступної дати (підтвердження)
    // Урл особистого кабінету студента де можно побачити список підтверджених завдань, та ті які не підтверджені
    //
}
