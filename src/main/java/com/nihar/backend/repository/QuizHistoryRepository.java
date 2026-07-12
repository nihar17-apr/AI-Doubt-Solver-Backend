package com.nihar.backend.repository;

import com.nihar.backend.entity.QuizHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizHistoryRepository extends JpaRepository<QuizHistory, Long> {

    long count();

}