package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.service.PerformanceService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceController {
    PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }
}
