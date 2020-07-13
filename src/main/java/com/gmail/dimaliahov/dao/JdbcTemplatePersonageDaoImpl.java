package com.gmail.dimaliahov.dao;

import com.gmail.dimaliahov.model.Enamu.Role;
import com.gmail.dimaliahov.model.Enamu.Subject;
import com.gmail.dimaliahov.model.Personage;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.DayOfWeek;
import java.util.List;

public class JdbcTemplatePersonageDaoImpl implements PersoneDao {

    private DataSource dataSource;
    private  JdbcTemplate jdbcTemplate;


    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createPersonage(Role role, Subject subject, String name, String surname, String mail, String password, String txt, Integer nal) {
        String SQL = "INSERT INTO DEVELOPERS (role, subject, name, surname, mail, password, txt, nal) VALUES (?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(SQL, role, subject, name, surname, mail, password, txt, nal);
        System.out.println("Developer successfully created.\nName: " + name +
                                                            ";\nSurname: " + surname +
                                                            ";\nRole: " + role +
                                                            ";\nSubject: " + subject +
                                                            ";\nMail: " + mail +
                                                            ";\nPassword: " + password +
                                                            ";\nTxt: " + txt +
                                                            ";\nNal: " + nal +
                                                            "\n");

    }

    @Override
    public Personage getPersonageById(Integer id) {
        String SQL = "SELECT * FROM DEVELOPERS WHERE id = ?";
        Personage personage = (Personage) jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PersonageMapper());
        return personage;
    }

//    @Override
//    public Personage getDeveloperById(Integer id) {
//        String SQL = "SELECT * FROM PERSONAGE WHERE id = ?";
//        Personage personage = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PersonageMapper());
//        return personage;
//    }

    @Override
    public List listPersonages() {
        String SQL = "SELECT * FROM PERSONAGE";
        List personage = jdbcTemplate.query(SQL, new PersonageMapper());
        return personage;
    }

    @Override
    public void removePersonage(Integer id) {
        String SQL = "DELETE FROM PERSONAGE WHERE id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Personage with id: " + id + " successfully removed");
    }

    @Override
    public void updatePersonage(Integer id, Role role, Subject subject, String name, String surname, String mail, String password, String txt, Integer nal) {
        String SQL = "UPDATE PERSONAGE SET name = ?, surname = ?, subject = ?, mail = ?, password = ?, txt = ?, nal = ?  WHERE id = ?";
        jdbcTemplate.update(SQL, role, subject, name, surname, mail, password, txt, nal);
        System.out.println("Developer with id: " + id + " successfully updated.");
    }
}
