package com.nihar.backend.controller;

import com.nihar.backend.dto.StudyPlanRequest;
import com.nihar.backend.dto.StudyPlanResponse;
import com.nihar.backend.service.StudyPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/study-planner")
@CrossOrigin("*")
public class StudyPlannerController {

    @Autowired
    private StudyPlannerService studyPlannerService;

    @PostMapping("/generate")
    public StudyPlanResponse generate(@RequestBody StudyPlanRequest request) {

        return studyPlannerService.generateStudyPlan(request);

    }
}