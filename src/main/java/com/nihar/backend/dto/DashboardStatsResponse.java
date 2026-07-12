package com.nihar.backend.dto;

public class DashboardStatsResponse {

    private long chatCount;
    private long quizCount;
    private long codeCount;
    private long subjectCount;

    public DashboardStatsResponse() {
    }

    public DashboardStatsResponse(long chatCount,
                                  long quizCount,
                                  long codeCount,
                                  long subjectCount) {
        this.chatCount = chatCount;
        this.quizCount = quizCount;
        this.codeCount = codeCount;
        this.subjectCount = subjectCount;
    }

    public long getChatCount() {
        return chatCount;
    }

    public void setChatCount(long chatCount) {
        this.chatCount = chatCount;
    }

    public long getQuizCount() {
        return quizCount;
    }

    public void setQuizCount(long quizCount) {
        this.quizCount = quizCount;
    }

    public long getCodeCount() {
        return codeCount;
    }

    public void setCodeCount(long codeCount) {
        this.codeCount = codeCount;
    }

    public long getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(long subjectCount) {
        this.subjectCount = subjectCount;
    }
}