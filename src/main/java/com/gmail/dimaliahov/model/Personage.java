package com.gmail.dimaliahov.model;


import com.gmail.dimaliahov.model.Enamu.Role;
import com.gmail.dimaliahov.model.Enamu.Subject;
import com.gmail.dimaliahov.model.additional.CalendarTracker;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "Personage")
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "subject")
    @OneToMany
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

    @OneToMany(
            mappedBy = "personage",
            cascade = CascadeType.ALL,
            orphanRemoval = true

    )
    private List <CalendarTracker>  calendarTeacher = new ArrayList<>();


    public Personage() {
        super();
    }

//    public Personage (int id, Role role, Subject subject, String name, String surname, int nal, int cost, String email, String txt, CalendarTracker calendarTrackerId){
//
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getNal() {
        return nal;
    }

    public void setNal(int nal) {
        this.nal = nal;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CalendarTracker> getCalendarTeacher() {
        return calendarTeacher;
    }

    public void setCalendarTeacher(List<CalendarTracker> calendarTeacher) {
        this.calendarTeacher = calendarTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personage personage = (Personage) o;
        return id == personage.id &&
                nal == personage.nal &&
                cost == personage.cost &&
                role == personage.role &&
                Objects.equals(subject, personage.subject) &&
                Objects.equals(name, personage.name) &&
                Objects.equals(surname, personage.surname) &&
                Objects.equals(email, personage.email) &&
                Objects.equals(txt, personage.txt) &&
                Objects.equals(password, personage.password) &&
                Objects.equals(calendarTeacher, personage.calendarTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, subject, name, surname, nal, cost, email, txt, password, calendarTeacher);
    }


}
