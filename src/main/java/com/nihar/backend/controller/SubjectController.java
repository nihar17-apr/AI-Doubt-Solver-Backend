package com.nihar.backend.controller;

import com.nihar.backend.entity.Subject;
import com.nihar.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin("*")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject) {
        return subjectService.addSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id,
                                 @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return "Subject deleted successfully";
    }
}