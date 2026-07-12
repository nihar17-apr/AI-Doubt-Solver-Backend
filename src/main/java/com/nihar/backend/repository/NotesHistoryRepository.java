package com.nihar.backend.repository;

import com.nihar.backend.entity.NotesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesHistoryRepository extends JpaRepository<NotesHistory, Long> {

    long count();

}