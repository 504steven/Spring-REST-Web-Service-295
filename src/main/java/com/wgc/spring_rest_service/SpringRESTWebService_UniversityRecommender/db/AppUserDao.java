package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class AppUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int saveAppUser(AppUser s){
        String sql = "INSERT INTO app_user (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, AGE, STATUS, CURRENTID, SCHOOLNAME, GPA, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int res = jdbcTemplate.update(sql, s.getEmail(), s.getPassword(), s.getFirstName(), s.getLastName(), s.getGender(),
                s.getAge(), s.getStatus(), s.getCurrentId(), s.getSchoolName(), s.getGpa(), s.getSAT_math(), s.getSAT_verbal(),
                s.getExpense_limit());
        return res;
    }

    public AppUser getAppUserById(int userId){
        String sql = "SELECT * FROM app_user WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, AppUser.class, userId);
    }

    public AppUser getAppUserByEmail(String email){
        String sql = "SELECT * FROM app_user WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, AppUser.class, email);
    }

    @Transactional
    public void transactonTest() {
//        String sql ="INSERT INTO student (NAME, AGE, GENDER, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) VALUES(\"xxx111\", 111, \"sex\", 0, 0, 0)";
//        jdbcTemplate.update(sql);
//        throw new DataAccessException("created exception!") {};
    }
}
