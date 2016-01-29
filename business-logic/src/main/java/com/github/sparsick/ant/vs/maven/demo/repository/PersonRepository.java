package com.github.sparsick.ant.vs.maven.demo.repository;

import com.github.sparsick.ant.vs.maven.demo.domain.Person;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class PersonRepository {

    private JdbcTemplate jdbcTemplate;


    @Autowired(required = true)
    public PersonRepository(DataSource dataSource) {
        checkJdbcDriver();
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public PersonRepository() {

    }


    public List<Person> findAllPersons() {
        return jdbcTemplate.query("Select * from person;", (ResultSet resultSet, int index) -> {
            Person person = new Person();
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setJobTitle(resultSet.getString("job_title"));
            return person;
        });

    }


    public void save(Person person) {
//        jdbcTemplate.update("Insert into person (first_name,last_name) values(?,?)", person.getFirstName(),
//                person.getLastName());
        
        
        jdbcTemplate.update("Insert into person (first_name,last_name,job_title) values(?,?,?)", person.getFirstName(),
                person.getLastName(), person.getJobTitle());
    }

    private void checkJdbcDriver() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            throw new RuntimeException("Cannot load JDBC driver", ex);
        }
    }
}
