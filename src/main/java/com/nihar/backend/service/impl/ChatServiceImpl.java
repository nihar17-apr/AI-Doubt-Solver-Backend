package com.nihar.backend.service.impl;

import com.nihar.backend.dto.ChatRequest;
import com.nihar.backend.dto.ChatResponse;
import com.nihar.backend.entity.ChatHistory;
import com.nihar.backend.entity.User;
import com.nihar.backend.repository.ChatHistoryRepository;
import com.nihar.backend.repository.UserRepository;
import com.nihar.backend.service.ChatService;
import com.nihar.backend.service.ai.GroqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private GroqService groqService;

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ChatResponse askQuestion(ChatRequest request) {

        String answer = groqService.askGroq(request.getQuestion());

        // Get logged-in user's email from JWT
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ChatHistory chat = new ChatHistory();
        chat.setQuestion(request.getQuestion());
        chat.setAnswer(answer);
        chat.setCreatedAt(LocalDateTime.now());
        chat.setUser(user);

        chatHistoryRepository.save(chat);

        return new ChatResponse(answer);
    }

    @Override
    public List<ChatHistory> getAllChats() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return chatHistoryRepository.findByUser(user);
    }

    @Override
    public void deleteChat(Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        chatHistoryRepository.deleteByIdAndUser(id, user);
    }
}