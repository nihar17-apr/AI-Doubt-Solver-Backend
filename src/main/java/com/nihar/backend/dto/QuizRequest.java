package com.nihar.backend.dto;

public class QuizRequest {

    private String topic;
    private String difficulty;
    private int questionCount;

    public QuizRequest() {
    }

    public QuizRequest(String topic, String difficulty, int questionCount) {
        this.topic = topic;
        this.difficulty = difficulty;
        this.questionCount = questionCount;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }
}