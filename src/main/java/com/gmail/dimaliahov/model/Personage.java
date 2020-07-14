package com.gmail.dimaliahov.model;


import com.gmail.dimaliahov.model.Enamu.Role;
import com.gmail.dimaliahov.model.Enamu.Subject;
import com.gmail.dimaliahov.model.additional.CalendarTracker;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "subject")
    @ManyToMany
    private Subject subject;

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

    @ManyToMany
    @JoinColumn(name = "calendarTracker")
    private CalendarTracker calendarTracker;

//    Списком в моделі лежатимуть заняття, і в студента і в викладача.
//    Треба зробить так що ссилка на обєкт listCalendar була однакова і в викладача і в студента.


}
