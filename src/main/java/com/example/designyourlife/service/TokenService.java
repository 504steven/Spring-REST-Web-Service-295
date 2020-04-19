package com.example.designyourlife.service;

import com.example.designyourlife.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public boolean verify(String token) {
        return true;
    }

    public String sign(Student studnet) {
        return null;
    }
}
