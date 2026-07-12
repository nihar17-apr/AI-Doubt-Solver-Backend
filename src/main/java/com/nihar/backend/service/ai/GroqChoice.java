package com.nihar.backend.service.ai;

public class GroqChoice {

    private GroqMessage message;

    public GroqChoice() {
    }

    public GroqMessage getMessage() {
        return message;
    }

    public void setMessage(GroqMessage message) {
        this.message = message;
    }
}