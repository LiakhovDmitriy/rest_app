package com.gmail.dimaliahov.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(schema = "json", name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String password;
    private String txt;
    private int cash;
    private String mail;

//    private List<CalendarTreack> listCalendar;

}
