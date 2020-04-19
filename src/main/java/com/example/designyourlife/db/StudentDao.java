package com.example.designyourlife.db;

import com.example.designyourlife.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveStudent(Student s){
        String sql = "INSERT INTO student (NAME, AGE, GENDER, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) VALUES(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, s.getName(), s.getAge(), s.getGender(), s.getSatMath(), s.getSatVerbal(), s.getExpense_limit());
    }

    public Student getStudent(int id){
        String sql = "SELECT * FROM student s WHERE s.id = ?";
        return jdbcTemplate.queryForObject(sql, Student.class);
    }

    public int saveStudentTest(){
        String sql = "INSERT INTO student (NAME, AGE, GENDER, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) VALUES(\"xxx22\", 222, \"sex\", 0, 0, 0)";
        return jdbcTemplate.update(sql);
    }

    @Transactional
    public void transactonTest() {
        String sql ="INSERT INTO student (NAME, AGE, GENDER, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) VALUES(\"xxx111\", 111, \"sex\", 0, 0, 0)";
        jdbcTemplate.update(sql);
        throw new DataAccessException("created exception!") {};
    }
}
