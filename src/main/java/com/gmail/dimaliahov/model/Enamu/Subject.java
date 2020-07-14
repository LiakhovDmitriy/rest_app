package com.gmail.dimaliahov.model.Enamu;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubject")
    private int id;

    @Column(name = "namesubject")
    private String nameSubject;



}
