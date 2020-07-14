package com.gmail.dimaliahov.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column (name = "role")
//    private Role role;
//
//    @Column(name = "subject")
//    private List<Subject> subjectList;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "nal")
    private int nal;

    @Column (name = "cost")
    private int cost;

    @Column (name = "email")
    private String email;

    @Column (name = "txt")
    private String txt;

    @Column (name = "password")
    private String password;

//    @Column (name = "listCalendar")
//    private List<CalendarTracker> listCalendar; // Списком в моделі лежатимуть заняття, і в студента і в викладача.
//    //Треба зробить так що ссилка на обєкт listCalendar була однакова і в викладача і в студента.


}
