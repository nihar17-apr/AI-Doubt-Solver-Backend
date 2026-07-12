package com.nihar.backend.dto;

public class NotesRequest {

    private String notes;
    private String summaryLength;

    public NotesRequest() {
    }

    public NotesRequest(String notes, String summaryLength) {
        this.notes = notes;
        this.summaryLength = summaryLength;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSummaryLength() {
        return summaryLength;
    }

    public void setSummaryLength(String summaryLength) {
        this.summaryLength = summaryLength;
    }
}