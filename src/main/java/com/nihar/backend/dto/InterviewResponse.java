package com.nihar.backend.dto;

public class InterviewResponse {

    private String questions;

    public InterviewResponse() {
    }

    public InterviewResponse(String questions) {
        this.questions = questions;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}