package com.nihar.backend.service.impl;
import com.nihar.backend.service.ai.GroqService;
import com.nihar.backend.dto.QuizRequest;
import com.nihar.backend.dto.QuizResponse;
import com.nihar.backend.entity.QuizHistory;
import com.nihar.backend.repository.QuizHistoryRepository;
import com.nihar.backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private QuizHistoryRepository quizHistoryRepository;

    @Override
    public QuizResponse generateQuiz(QuizRequest request) {

        String prompt =
                "Generate " + request.getQuestionCount() +
                        " multiple choice questions about " + request.getTopic() +
                        ". Difficulty: " + request.getDifficulty() +
                        ". For each question include:\n" +
                        "1. Question\n" +
                        "2. Four options (A, B, C, D)\n" +
                        "3. Correct Answer\n" +
                        "4. Short Explanation\n\n" +
                        "Return the quiz in clean markdown format.";

        String quiz = groqService.askGroq(prompt);

        QuizHistory history = new QuizHistory();

        history.setTopic(request.getTopic());
        history.setDifficulty(request.getDifficulty());
        history.setQuestionCount(request.getQuestionCount());
        history.setQuizContent(quiz);
        history.setCreatedAt(LocalDateTime.now());

        quizHistoryRepository.save(history);

        return new QuizResponse(quiz);
    }
}