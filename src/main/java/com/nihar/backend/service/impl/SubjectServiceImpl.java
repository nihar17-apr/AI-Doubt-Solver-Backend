package com.nihar.backend.service.impl;

import com.nihar.backend.entity.Subject;
import com.nihar.backend.repository.SubjectRepository;
import com.nihar.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject addSubject(Subject subject) {
        if(subjectRepository.existsBySubjectName(subject.getSubjectName())){
            throw new RuntimeException("Subject already exists");
        }
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubject(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @Override
    public Subject updateSubject(Long id, Subject subject) {

        Subject existing = getSubject(id);

        existing.setSubjectName(subject.getSubjectName());
        existing.setDescription(subject.getDescription());

        return subjectRepository.save(existing);
    }
    @Override
    public void deleteSubject(Long id) {
        Subject subject = getSubject(id);
        subjectRepository.delete(subject);
    }
}