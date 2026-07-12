package com.nihar.backend.service.impl;

import com.nihar.backend.dto.InterviewRequest;
import com.nihar.backend.dto.InterviewResponse;
import com.nihar.backend.entity.InterviewHistory;
import com.nihar.backend.repository.InterviewHistoryRepository;
import com.nihar.backend.service.InterviewService;
import com.nihar.backend.service.ai.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private InterviewHistoryRepository interviewHistoryRepository;

    @Override
    public InterviewResponse generateInterviewQuestions(InterviewRequest request) {

        String prompt =
                "Generate " + request.getQuestionCount() +
                        " interview questions for " + request.getTechnology() +
                        ". Experience Level: " + request.getLevel() +
                        ". For every question provide:\n\n" +
                        "1. Question\n" +
                        "2. Detailed Answer\n" +
                        "3. Best Practices\n" +
                        "4. Common Mistakes\n\n" +
                        "Return everything in clean Markdown.";

        String result = groqService.askGroq(prompt);

        InterviewHistory history = new InterviewHistory();
        history.setTechnology(request.getTechnology());
        history.setLevel(request.getLevel());
        history.setQuestionCount(request.getQuestionCount());
        history.setQuestions(result);
        history.setCreatedAt(LocalDateTime.now());

        interviewHistoryRepository.save(history);

        return new InterviewResponse(result);
    }
}