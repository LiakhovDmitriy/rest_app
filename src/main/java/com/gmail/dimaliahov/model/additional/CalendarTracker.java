package com.gmail.dimaliahov.model.additional;

import com.gmail.dimaliahov.model.Enamu.StatusCalendar;
import lombok.Data;

import java.util.Date;

@Data
public class CalendarTracker {

        private int id;

        private int idStudent;

        private int idTeacher;

        private Date timeStart;

        private Date timeEnd;

        private StatusCalendar statusCalendar;

        private int hoursDuration;

        //  По факту якщо і в викладача і студента  є ссилка на один і той же самий CalendarTreack, то не треба їх ID сюди.
        //  Але хай буде поки що

}
