package com.gmail.dimaliahov.model.additional;

import com.gmail.dimaliahov.model.Enamu.Role;
import com.gmail.dimaliahov.model.Enamu.StatusCalendar;
import com.gmail.dimaliahov.model.Enamu.Subject;
import com.gmail.dimaliahov.model.Personage;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "calendartracker")
public class CalendarTracker {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idCal")
        private int id;

        @Column (name = "statusCal")
        @Enumerated(EnumType.STRING)
        private StatusCalendar statusCalendar;

        @Column(name = "idStudentCal")
        private int idStudent;

        @Column(name = "idTeacherCal")
        private int idTeacher;

        @Column(name = "timeStartCal")
        private Date timeStart;

        @Column(name = "timeEndCal")
        private Date timeEnd;

        @Column(name = "subjectCal")
        private Subject subject;

        @Column(name = "hoursDurationCal")
        private int hoursDuration;

        @OneToMany(
                mappedBy = "calendarCal",
                cascade = CascadeType.ALL,
                orphanRemoval = true
        )
        private List<Personage> personages = new ArrayList<>();

        //  По факту якщо і в викладача і студента  є ссилка на один і той же самий CalendarTreack, то не треба їх ID сюди.
        //  Але хай буде поки що
        // І треба зробить коли вільний викладач.

}
