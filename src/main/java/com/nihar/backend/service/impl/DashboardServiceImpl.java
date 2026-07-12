package com.nihar.backend.service.impl;

import com.nihar.backend.dto.DashboardStatsResponse;
import com.nihar.backend.repository.ChatHistoryRepository;
import com.nihar.backend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    @Override
    public DashboardStatsResponse getDashboardStats() {

        long chatCount = chatHistoryRepository.count();

        long quizCount = 0;
        long codeCount = 0;
        long subjectCount = 0;

        return new DashboardStatsResponse(
                chatCount,
                quizCount,
                codeCount,
                subjectCount
        );
    }
}