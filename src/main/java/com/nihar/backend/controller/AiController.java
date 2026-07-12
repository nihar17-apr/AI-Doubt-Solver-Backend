package com.nihar.backend.controller;

import com.nihar.backend.dto.ChatRequest;
import com.nihar.backend.dto.ChatResponse;
import com.nihar.backend.entity.ChatHistory;
import com.nihar.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin("*")
public class AiController {

    @Autowired
    private ChatService chatService;

    // Ask AI
    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.askQuestion(request);
    }

    // Get all chat history
    @GetMapping("/history")
    public List<ChatHistory> getHistory() {
        return chatService.getAllChats();
    }

    // Delete chat
    @DeleteMapping("/history/{id}")
    public String deleteChat(@PathVariable Long id) {
        chatService.deleteChat(id);
        return "Chat deleted successfully.";
    }
}