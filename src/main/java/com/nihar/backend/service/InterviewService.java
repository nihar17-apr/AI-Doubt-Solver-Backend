package com.nihar.backend.service;

import com.nihar.backend.dto.InterviewRequest;
import com.nihar.backend.dto.InterviewResponse;

public interface InterviewService {

    InterviewResponse generateInterviewQuestions(InterviewRequest request);

}