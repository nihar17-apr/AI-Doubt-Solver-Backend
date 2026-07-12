package com.nihar.backend.controller;

import com.nihar.backend.dto.QuizRequest;
import com.nihar.backend.dto.QuizResponse;
import com.nihar.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/generate")
    public QuizResponse generateQuiz(@RequestBody QuizRequest request) {

        return quizService.generateQuiz(request);

    }
}