package com.example.kalasethubackend.service;

import com.example.kalasethubackend.model.PerformanceAssignment;
import com.example.kalasethubackend.repository.PerformanceAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceAssignmentService {
    PerformanceAssignmentRepository performanceAssignmentRepository;

    public PerformanceAssignmentService(PerformanceAssignmentRepository performanceAssignmentRepository) {
        this.performanceAssignmentRepository = performanceAssignmentRepository;
    }


    public PerformanceAssignment addAssignment(PerformanceAssignment assignment) {
        return performanceAssignmentRepository.save(assignment);
    }
}
