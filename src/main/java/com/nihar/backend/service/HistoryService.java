package com.nihar.backend.service;

import com.nihar.backend.dto.ChatHistoryResponse;

import java.util.List;

public interface HistoryService {

    List<ChatHistoryResponse> getChatHistory();

    void deleteChat(Long id);

    void clearChatHistory();

}