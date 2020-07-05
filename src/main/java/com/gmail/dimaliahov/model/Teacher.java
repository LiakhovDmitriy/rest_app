package com.gmail.dimaliahov.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(schema = "json", name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String password;
    private String txt;
    private int cash;
    private String mail;
//    private List<CalendarTreack> listCalendar;


    public Teacher() {
        super();
    }

    public Teacher(long id, String surname) {
        this.id = id;
        this.surname = surname;
    }


}
