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
    @Column (name = "id")
    private long id;

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

    @Column (name = "listCalendar")
    private List<CalendarTreack> listCalendar;

    // Додать поле для предмету який викладає викладач (Походу зроблю ЕНАМ доступних предметів)
    //

}
