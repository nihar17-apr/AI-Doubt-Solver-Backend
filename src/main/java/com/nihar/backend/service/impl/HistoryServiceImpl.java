package com.nihar.backend.service.impl;

import com.nihar.backend.dto.ChatHistoryResponse;
import com.nihar.backend.entity.ChatHistory;
import com.nihar.backend.entity.User;
import com.nihar.backend.repository.ChatHistoryRepository;
import com.nihar.backend.repository.UserRepository;
import com.nihar.backend.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ChatHistoryResponse> getChatHistory() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();
        System.out.println("Current User = " + email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<ChatHistory> chats = chatHistoryRepository.findByUser(user);

        return chats.stream()
                .map(chat -> new ChatHistoryResponse(
                        chat.getId(),
                        chat.getQuestion(),
                        chat.getAnswer(),
                        chat.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteChat(Long id) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        chatHistoryRepository.deleteByIdAndUser(id, user);
    }

    @Override
    public void clearChatHistory() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        chatHistoryRepository.deleteAllByUser(user);
    }
}