package com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.controller;


import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.db.StudentDao;
import com.wgc.spring_rest_service.SpringRESTWebService_UniversityRecommender.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
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
