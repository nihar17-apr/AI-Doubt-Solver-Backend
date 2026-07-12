package com.nihar.backend.controller;

import com.nihar.backend.dto.NotesRequest;
import com.nihar.backend.dto.NotesResponse;
import com.nihar.backend.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin("*")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("/summarize")
    public NotesResponse summarize(@RequestBody NotesRequest request) {

        return notesService.summarizeNotes(request);

    }
}