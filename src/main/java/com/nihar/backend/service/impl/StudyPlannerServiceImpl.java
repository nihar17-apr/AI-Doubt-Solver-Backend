package com.nihar.backend.service.impl;

import com.nihar.backend.dto.StudyPlanRequest;
import com.nihar.backend.dto.StudyPlanResponse;
import com.nihar.backend.entity.StudyPlanHistory;
import com.nihar.backend.repository.StudyPlanHistoryRepository;
import com.nihar.backend.service.StudyPlannerService;
import com.nihar.backend.service.ai.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudyPlannerServiceImpl implements StudyPlannerService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private StudyPlanHistoryRepository studyPlanHistoryRepository;

    @Override
    public StudyPlanResponse generateStudyPlan(StudyPlanRequest request) {

        String prompt =
                "Create a personalized study plan.\n\n" +
                        "Exam: " + request.getExamName() + "\n" +
                        "Days Left: " + request.getDaysLeft() + "\n" +
                        "Study Hours Per Day: " + request.getStudyHours() + "\n" +
                        "Weak Subjects: " + request.getWeakSubjects() + "\n" +
                        "Goal: " + request.getGoal() + "\n\n" +

                        "Generate:\n" +
                        "1. Daily Study Timetable\n" +
                        "2. Topics to Study\n" +
                        "3. Revision Schedule\n" +
                        "4. Mock Test Plan\n" +
                        "5. Daily Motivation Tips\n\n" +

                        "Return everything in clean Markdown.";

        String result = groqService.askGroq(prompt);

        StudyPlanHistory history = new StudyPlanHistory();

        history.setExamName(request.getExamName());
        history.setDaysLeft(request.getDaysLeft());
        history.setStudyHours(request.getStudyHours());
        history.setWeakSubjects(request.getWeakSubjects());
        history.setGoal(request.getGoal());
        history.setPlan(result);
        history.setCreatedAt(LocalDateTime.now());

        studyPlanHistoryRepository.save(history);

        return new StudyPlanResponse(result);
    }
}