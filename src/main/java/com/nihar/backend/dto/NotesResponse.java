package com.nihar.backend.dto;

public class NotesResponse {

    private String summary;

    public NotesResponse() {
    }

    public NotesResponse(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}