package com.gmail.dimaliahov.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dimaliahov.dao.JdbcTemplatePersonageDaoImpl;
import com.gmail.dimaliahov.model.Personage;

import com.gmail.dimaliahov.repository.PersonageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    ApplicationContext context =
            new ClassPathXmlApplicationContext("jdbctemplate-personage-config.xml");

    JdbcTemplatePersonageDaoImpl jdbcTemplateDeveloperDao =
            (JdbcTemplatePersonageDaoImpl) context.getBean("jdbcTemplatePersonageDao");


    @Autowired
    public PersonageController(PersonageRepository teacherRepository){
        this.personageRepository = teacherRepository;
    }

    @RequestMapping("json")
    public void json (){
        //записали json дані з ресурсів
        URL url =  this.getClass().getClassLoader().getResource("personage.json"); // ALERT нове потім написать
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

    @RequestMapping("list")
    public void showList (){
        List personage = jdbcTemplateDeveloperDao.listPersonages();
        for (Object personages : personage) {
            System.out.println(personage);
        }


    }

    //Написать новий один JSON з разними ролями. адміна, вчителя, студента.

    // урл для створення
    // урл для редагування
    // урл для видалення
    // Витягти ліст по РОЛІ
    // (особистий кабінет) урл де можно вибрати викладача (+ бачить ціну за час)

    // Особистий кабінет щось придумать що там має бути

    // Після вибору викладача, має бути вибір доступної дати (підтвердження)
    // Урл особистого кабінету  де можно побачити список СТАТУСУ завдань


}
