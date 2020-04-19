package com.example.designyourlife.controller;

import com.example.designyourlife.db.StudentDao;
import com.example.designyourlife.entity.Student;
import com.example.designyourlife.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentDao.getStudent(id);
    }

    public boolean addStudent(Student student) {
        return true;
    }

    public boolean updateStudent(Student student) {
        return true;
    }

}
