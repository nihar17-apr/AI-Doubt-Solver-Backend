package com.nihar.backend.controller;

import com.nihar.backend.dto.InterviewRequest;
import com.nihar.backend.dto.InterviewResponse;
import com.nihar.backend.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
@CrossOrigin("*")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/generate")
    public InterviewResponse generate(@RequestBody InterviewRequest request) {

        return interviewService.generateInterviewQuestions(request);

    }
}