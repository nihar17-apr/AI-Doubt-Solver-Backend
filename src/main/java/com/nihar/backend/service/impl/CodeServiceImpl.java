package com.nihar.backend.service.impl;

import com.nihar.backend.dto.CodeRequest;
import com.nihar.backend.dto.CodeResponse;
import com.nihar.backend.entity.CodeHistory;
import com.nihar.backend.repository.CodeHistoryRepository;
import com.nihar.backend.service.CodeService;
import com.nihar.backend.service.ai.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private CodeHistoryRepository codeHistoryRepository;

    @Override
    public CodeResponse generateCode(CodeRequest request) {

        String prompt =
                "Generate " + request.getLanguage() + " code for the following problem:\n\n"
                        + request.getPrompt()
                        + "\n\nAlso provide:\n"
                        + "1. Explanation\n"
                        + "2. Time Complexity\n"
                        + "3. Space Complexity\n"
                        + "Return everything in clean Markdown.";

        String result = groqService.askGroq(prompt);

        CodeHistory history = new CodeHistory();
        history.setLanguage(request.getLanguage());
        history.setPrompt(request.getPrompt());
        history.setGeneratedCode(result);
        history.setCreatedAt(LocalDateTime.now());

        codeHistoryRepository.save(history);

        return new CodeResponse(result);
    }
}