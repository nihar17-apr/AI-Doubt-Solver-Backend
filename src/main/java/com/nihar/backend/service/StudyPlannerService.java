package com.nihar.backend.service;

import com.nihar.backend.dto.StudyPlanRequest;
import com.nihar.backend.dto.StudyPlanResponse;

public interface StudyPlannerService {

    StudyPlanResponse generateStudyPlan(StudyPlanRequest request);

}