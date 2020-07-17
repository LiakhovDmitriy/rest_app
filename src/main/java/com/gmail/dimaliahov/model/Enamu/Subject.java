package com.gmail.dimaliahov.model.Enamu;

import com.gmail.dimaliahov.model.Personage;
import lombok.Data;

import javax.persistence.*;

@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsubject")
    private int id;

    @Column(name = "namesubject")
    private String nameSubject;

    @ManyToOne
    private Personage personage;


}
