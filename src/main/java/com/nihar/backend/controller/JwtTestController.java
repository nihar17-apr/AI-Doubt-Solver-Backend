package com.nihar.backend.controller;

import com.nihar.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtTestController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/token")
    public String token() {
        return jwtUtil.generateToken("nihar@gmail.com");
    }
}