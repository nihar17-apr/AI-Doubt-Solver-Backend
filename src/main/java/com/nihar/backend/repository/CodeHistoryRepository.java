package com.nihar.backend.repository;

import com.nihar.backend.entity.CodeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeHistoryRepository extends JpaRepository<CodeHistory, Long> {

    long count();

}