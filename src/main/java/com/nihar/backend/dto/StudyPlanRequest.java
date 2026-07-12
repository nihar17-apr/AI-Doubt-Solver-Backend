package com.nihar.backend.dto;

public class StudyPlanRequest {

    private String examName;
    private int daysLeft;
    private int studyHours;
    private String weakSubjects;
    private String goal;

    public StudyPlanRequest() {
    }

    public StudyPlanRequest(String examName, int daysLeft, int studyHours,
                            String weakSubjects, String goal) {
        this.examName = examName;
        this.daysLeft = daysLeft;
        this.studyHours = studyHours;
        this.weakSubjects = weakSubjects;
        this.goal = goal;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getStudyHours() {
        return studyHours;
    }

    public void setStudyHours(int studyHours) {
        this.studyHours = studyHours;
    }

    public String getWeakSubjects() {
        return weakSubjects;
    }

    public void setWeakSubjects(String weakSubjects) {
        this.weakSubjects = weakSubjects;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}