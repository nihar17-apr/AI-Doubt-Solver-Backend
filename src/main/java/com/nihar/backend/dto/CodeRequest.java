package com.nihar.backend.dto;

public class CodeRequest {

    private String language;
    private String prompt;

    public CodeRequest() {
    }

    public CodeRequest(String language, String prompt) {
        this.language = language;
        this.prompt = prompt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}