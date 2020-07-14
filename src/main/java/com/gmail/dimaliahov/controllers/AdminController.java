package com.gmail.dimaliahov.controllers;

import com.gmail.dimaliahov.exception.ResourceNotFoundException;
import com.gmail.dimaliahov.model.Personage;
import com.gmail.dimaliahov.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    private PersonageRepository personageRepository;



    // Достать всих
    @RequestMapping("/pesonages")
    public Page<Personage> getAll(Pageable pageable) {
        return personageRepository.findAll(pageable);
    }


    // Створить Одного
    @PostMapping("/pesonages")
    public Personage createPersonage(@Valid @RequestBody Personage personage){
        return personageRepository.save(personage);
    }

    // Достать одного
    @PutMapping("/pesonages/{personageId}")
    public Personage updatePersonage(@PathVariable Long personageId,
                                     @Valid @RequestBody Personage personageRequast) {
        return personageRepository.findById(personageId)
                .map(question -> {
                    question.setName(personageRequast.getName());
                    question.setSurname(personageRequast.getSurname());
                    return personageRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + personageId));
    }


    // Удалить
    @DeleteMapping("/pesonages/{personageId}")
    public ResponseEntity<?> deletePersonage(@PathVariable Long personageId) {
        return personageRepository.findById(personageId)
                .map(personage -> {
                    personageRepository.delete(personage);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + personageId));
    }



    //Для ролі Адмін
    // урл для списка студентів/викладачів
    // редагування їх по ІД
    // урл для зміни задач між вчителем та студентом
    // Spring Security зможе позакривать урли для окремих урлів (подивиться як доступ краще хранить в сесії/кеші)

}
