package com.gmail.dimaliahov.model.additional;

import lombok.Data;

import java.util.Date;

@Data
public class CalendarTracker {

        private Date idTimeStart;

        private Date idTimeEnd;

        private StatusCalendar statusCalendar;

        private int hours;

        private int idStudent;

        private int idTeacher;

        //  По факту якщо і в викладача і студента  є ссилка на один і той же самий CalendarTreack, то не треба їх ID сюди.
        //  Але хай буде поки що

}
