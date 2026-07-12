package com.nihar.backend.dto;

public class InterviewRequest {

    private String technology;
    private String level;
    private int questionCount;

    public InterviewRequest() {
    }

    public InterviewRequest(String technology, String level, int questionCount) {
        this.technology = technology;
        this.level = level;
        this.questionCount = questionCount;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}