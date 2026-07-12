package com.nihar.backend.repository;

import com.nihar.backend.entity.StudyPlanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanHistoryRepository extends JpaRepository<StudyPlanHistory, Long> {

    long count();

}