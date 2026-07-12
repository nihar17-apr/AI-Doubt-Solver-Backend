package com.nihar.backend.service;

import com.nihar.backend.entity.Subject;

import java.util.List;

public interface SubjectService {

    Subject addSubject(Subject subject);

    List<Subject> getAllSubjects();


    Subject getSubject(Long id);

    Subject updateSubject(Long id, Subject subject);

    void deleteSubject(Long id);
}