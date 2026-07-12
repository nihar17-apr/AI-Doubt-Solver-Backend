package com.nihar.backend.controller;

import com.nihar.backend.dto.DashboardStatsResponse;
import com.nihar.backend.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardStatsResponse getDashboardStats() {

        return dashboardService.getDashboardStats();

    }
}