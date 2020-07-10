package com.gmail.dimaliahov.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.dimaliahov.model.Student;
import com.gmail.dimaliahov.model.Teacher;
import com.gmail.dimaliahov.repository.StudentRepository;
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
public class StudentController {
    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    private StudentRepository studentRepository;

    @Autowired
    public StudentController (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @RequestMapping("jsonS")
    public void json (){
        //записали json дані з ресурсів
        URL url =  this.getClass().getClassLoader().getResource("student.json");
        if (url != null){
            File jsonFile = new File(url.getFile());
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                List<Student> students = objectMapper.readValue(jsonFile, new TypeReference<List<Student>>(){});
                studentRepository.saveAll(students);
                logger.info("All record saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("Url is null");
        }
    }

    // урл для створення студента
    // урл для редагування
    // урл для видалення
    // (особистий кабінет) урл де можно вибрати викладача (+ бачить ціну за час)
            // Додати поле де вказана ціна за час
    // Після вибору викладача, має бути вибір доступної дати (підтвердження)
    // Урл особистого кабінету студента де можно побачити список підтверджених завдань, та ті які не підтверджені
    //
}
