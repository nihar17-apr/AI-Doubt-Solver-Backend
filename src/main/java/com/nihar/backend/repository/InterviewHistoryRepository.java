package com.nihar.backend.repository;

import com.nihar.backend.entity.InterviewHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewHistoryRepository extends JpaRepository<InterviewHistory, Long> {

    long count();

}