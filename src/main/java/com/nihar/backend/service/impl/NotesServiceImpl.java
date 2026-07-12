package com.nihar.backend.service.impl;

import com.nihar.backend.dto.NotesRequest;
import com.nihar.backend.dto.NotesResponse;
import com.nihar.backend.entity.NotesHistory;
import com.nihar.backend.repository.NotesHistoryRepository;
import com.nihar.backend.service.NotesService;
import com.nihar.backend.service.ai.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private NotesHistoryRepository notesHistoryRepository;

    @Override
    public NotesResponse summarizeNotes(NotesRequest request) {

        String prompt =
                "Summarize the following notes.\n\n"
                        + "Summary Length: " + request.getSummaryLength() + "\n\n"
                        + request.getNotes()
                        + "\n\nAlso provide:\n"
                        + "1. Summary\n"
                        + "2. Key Points\n"
                        + "3. Important Interview Questions\n"
                        + "Return the response in clean Markdown.";

        String result = groqService.askGroq(prompt);

        NotesHistory history = new NotesHistory();
        history.setNotes(request.getNotes());
        history.setSummary(result);
        history.setSummaryLength(request.getSummaryLength());
        history.setCreatedAt(LocalDateTime.now());

        notesHistoryRepository.save(history);

        return new NotesResponse(result);
    }
}