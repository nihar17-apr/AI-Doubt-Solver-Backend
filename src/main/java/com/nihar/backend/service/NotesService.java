package com.nihar.backend.service;

import com.nihar.backend.dto.NotesRequest;
import com.nihar.backend.dto.NotesResponse;

public interface NotesService {

    NotesResponse summarizeNotes(NotesRequest request);

}