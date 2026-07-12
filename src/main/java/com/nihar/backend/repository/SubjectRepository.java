package com.nihar.backend.repository;

import com.nihar.backend.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    boolean existsBySubjectName(String subjectName);

}