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
    @Column (name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "password")
    private String password;

    @Column (name = "txt")
    private String txt;

    @Column (name = "cash")
    private int cash;

    @Column (name = "mail")
    private String mail;

    @Column (name = "list_calendar")
    private List<CalendarTreack> listCalendar;


    // додати поле предметів які потрібні студенту Енам походу
    // Походу треба зробити краще клас персону і вказати ролі а не окремі класи для вчителя/студента/адміна

}
