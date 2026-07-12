package com.nihar.backend.service;

import com.nihar.backend.dto.ChatRequest;
import com.nihar.backend.dto.ChatResponse;
import com.nihar.backend.entity.ChatHistory;

import java.util.List;

public interface ChatService {

    ChatResponse askQuestion(ChatRequest request);

    List<ChatHistory> getAllChats();

    void deleteChat(Long id);

}