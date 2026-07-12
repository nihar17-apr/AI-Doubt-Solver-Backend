package com.nihar.backend.service;

import com.nihar.backend.dto.QuizRequest;
import com.nihar.backend.dto.QuizResponse;

public interface QuizService {

    QuizResponse generateQuiz(QuizRequest request);

}