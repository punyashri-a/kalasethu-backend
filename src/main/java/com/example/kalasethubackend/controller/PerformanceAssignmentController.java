package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.model.PerformanceAssignment;
import com.example.kalasethubackend.service.PerformanceAssignmentService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<PerformanceAssignment> getAllAssignments(){
        return performanceAssignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public PerformanceAssignment getAssignmentById(@PathVariable("id") Long assignmentId){
        return performanceAssignmentService.getAssignmentById(assignmentId);
    }

    @PutMapping("/{id}")
    public PerformanceAssignment updateAssignment(@PathVariable("id") Long assignmentId,@RequestBody PerformanceAssignment assignment){
        return performanceAssignmentService.updateAssignment(assignmentId,assignment);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable("id") Long assignmentId){
        performanceAssignmentService.deleteAssignment(assignmentId);
    }

    @GetMapping("/performances/{performanceId}/artists")
    public List<Artist> getArtistsByPerformance(@PathVariable Long performanceId){
        return performanceAssignmentService.getArtistsByPerformance(performanceId);
    }
}
