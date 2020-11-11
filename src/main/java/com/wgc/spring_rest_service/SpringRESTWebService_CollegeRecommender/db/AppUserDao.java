package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.db;

import com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AppUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AppUserRowMapper appUserRowMapper = new AppUserRowMapper();


    public int saveAppUser(AppUser appUser){
        List<String> roles = appUser.getRoles();
        if(roles.isEmpty()) {
            roles.add("Student");
        }
        String sql = "INSERT INTO app_user (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, AGE, STATUS, CURRENTID, SCHOOLNAME, GPA, SAT_MATH, SAT_reading, SAT_writing, ACT, EXPENSE_LIMIT) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int res = jdbcTemplate.update(sql, appUser.getEmail(), appUser.getPassword(), appUser.getFirstName(), appUser.getLastName(), appUser.getGender(),
                appUser.getAge(), appUser.getStatus(), appUser.getCurrentId(), appUser.getSchoolName(), appUser.getGpa(), appUser.getSAT_math(), appUser.getSAT_reading(), appUser.getSAT_writing(), appUser.getACT(),
                appUser.getExpense_limit());
        int userId = jdbcTemplate.queryForObject("SELECT userId FROM app_user WHERE email = ? ", Integer.class, appUser.getEmail());
        for(String role : appUser.getRoles()) {
            sql = "INSERT INTO role VALUES (?, ?)";
            jdbcTemplate.update(sql, userId, role);
        }
        return res;
    }

    public AppUser getAppUserById(int userId){
        String sql = "SELECT * FROM app_user WHERE userId = ?";
        AppUser appUser = jdbcTemplate.queryForObject(sql, appUserRowMapper, userId);
        sql = "SELECT role FROM role WHERE userId = ?";
        List<String> roles = jdbcTemplate.queryForList(sql, String.class, userId);
        appUser.setRoles(roles);
        return appUser;
    }

    public AppUser getAppUserByEmail(String email){
        String sql = "SELECT * FROM app_user WHERE email = ?";
        AppUser appUser = jdbcTemplate.queryForObject(sql, appUserRowMapper, email);
        sql = "SELECT role FROM role WHERE userId = ?";
        List<String> roles = jdbcTemplate.queryForList(sql, String.class, appUser.getUserId());
        appUser.setRoles(roles);
        return appUser;
    }

    public int updateAppUser(AppUser appUser) {
        String sql = "UPDATE app_user SET email = ?, password = ?, firstname = ?, lastname = ?, gender = ?, age = ?, status = ?, currentid = ?, schoolname = ?, gpa = ?, sat_math = ?, SAT_reading = ?, SAT_writing = ?, ACT = ?, expense_limit = ? " +
                        " WHERE userId = ? ";
        int res = jdbcTemplate.update(sql, appUser.getEmail(), appUser.getPassword(), appUser.getFirstName(), appUser.getLastName(), appUser.getGender(),
                   appUser.getAge(), appUser.getStatus(), appUser.getCurrentId(), appUser.getSchoolName(), appUser.getGpa(), appUser.getSAT_math(), appUser.getSAT_reading(), appUser.getSAT_writing(), appUser.getACT(),
                    appUser.getExpense_limit(), appUser.getUserId());
        return res;
    }

    @Transactional
    public void transactonTest() {
//        String sql ="INSERT INTO student (NAME, AGE, GENDER, SAT_MATH, SAT_VERBAL, EXPENSE_LIMIT) VALUES(\"xxx111\", 111, \"sex\", 0, 0, 0)";
//        jdbcTemplate.update(sql);
//        throw new DataAccessException("created exception!") {};   // throw exception, will rollback the update sql operation
    }
}

class AppUserRowMapper implements RowMapper<AppUser> {

    @Override
    public AppUser mapRow(ResultSet resultSet, int i) throws SQLException {
        AppUser appUser = new AppUser();
        appUser.setUserId( resultSet.getInt("userId"));
        appUser.setEmail( resultSet.getString("email"));
        appUser.setPassword( resultSet.getString("password"));
        appUser.setFirstName( resultSet.getString("firstname"));
        appUser.setLastName( resultSet.getString("lastname"));
        appUser.setGender( resultSet.getString("gender"));
        appUser.setAge( resultSet.getInt("age"));
        appUser.setStatus( resultSet.getString("status"));
        appUser.setCurrentId( resultSet.getString("currentId"));
        appUser.setSchoolName( resultSet.getString("schoolname"));
        appUser.setGpa( resultSet.getDouble("gpa"));
        appUser.setSAT_math( resultSet.getInt("SAT_math"));
        appUser.setSAT_reading( resultSet.getInt("SAT_reading"));
        appUser.setSAT_writing( resultSet.getInt("SAT_writing"));
        appUser.setACT( resultSet.getInt("ACT"));
        appUser.setExpense_limit( resultSet.getInt("expense_limit"));
        return appUser;
    }
}
