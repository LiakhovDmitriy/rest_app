package com.gmail.dimaliahov.controllers;

import com.gmail.dimaliahov.model.Personage;
import com.gmail.dimaliahov.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Convert;

@RestController
public class AdminController {

    @Autowired
    private PersonageRepository personageRepository;

    @RequestMapping("/questions")
    public Page<Personage> getAll(Pageable pageable) {
        return personageRepository.findAll(pageable);
    }


    //Для ролі Адмін
    // урл для списка студентів/викладачів
    // редагування їх по ІД
    // урл для зміни задач між вчителем та студентом
    // Spring Security зможе позакривать урли для окремих урлів (подивиться як доступ краще хранить в сесії/кеші)

}
