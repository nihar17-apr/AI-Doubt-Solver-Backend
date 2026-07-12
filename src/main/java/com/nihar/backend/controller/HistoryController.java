package com.nihar.backend.controller;

import com.nihar.backend.dto.ChatHistoryResponse;
import com.nihar.backend.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin("*")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    // Get logged-in user's chat history
    @GetMapping("/chat")
    public List<ChatHistoryResponse> getChatHistory() {
        return historyService.getChatHistory();
    }

    @DeleteMapping("/chat/{id}")
    public String deleteChat(@PathVariable Long id) {

        System.out.println("DELETE API HIT");

        historyService.deleteChat(id);

        return "Chat deleted successfully";
    }

    // Clear all chats of logged-in user
    @DeleteMapping("/chat/clear")
    public String clearChatHistory() {

        historyService.clearChatHistory();

        return "All chat history deleted successfully";
    }
}