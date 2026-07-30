package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.model.PerformanceAssignment;
import com.example.kalasethubackend.service.PerformanceAssignmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class PerformanceAssignmentController {
    PerformanceAssignmentService performanceAssignmentService;

    public PerformanceAssignmentController(PerformanceAssignmentService performanceAssignmentService) {
        this.performanceAssignmentService = performanceAssignmentService;
    }

    @PostMapping
    public PerformanceAssignment addAssignment(@RequestBody PerformanceAssignment assignment){
        return performanceAssignmentService.addAssignment(assignment);
    }

}
