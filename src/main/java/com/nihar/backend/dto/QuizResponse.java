package com.nihar.backend.dto;

public class QuizResponse {

    private String quiz;

    public QuizResponse() {
    }

    public QuizResponse(String quiz) {
        this.quiz = quiz;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
}