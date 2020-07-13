package com.gmail.dimaliahov.dao;

import com.gmail.dimaliahov.model.Personage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonageMapper implements RowMapper {

//    Один класс представляет данные 1-ой записи, полученные от команды запроса (Query statement) называется классом  model.
//    Класс  Personage является классом  model.

//    Один класс используется для сопоставления (mapping) соответствующих 1-1 между 1 столбцом
//    в команде запроса и 1 полем (field) в классе  model называется классом  mapper.
//    PersonageMapper является таким классом.


    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Personage personage = new Personage();
        personage.setId(resultSet.getInt("id"));
        personage.setName(resultSet.getString("name"));
        personage.setSurname(resultSet.getString("surname"));
        personage.setMail(resultSet.getString("mail"));
        personage.setPassword(resultSet.getString("password"));
//        personage.setRole(resultSet.getString("role"));
//        personage.setNal(resultSet.getString("nal"));
//        personage.setCost(resultSet.getString("cost"));
//        Почему то не пашать ці поля
        return personage;
    }
}
