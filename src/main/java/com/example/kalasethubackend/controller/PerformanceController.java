package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.model.Performance;
import com.example.kalasethubackend.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performances")
public class PerformanceController {
    PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @PostMapping
    public Performance addPerformance(@RequestBody Performance performance){
        return performanceService.addPerformance(performance);
    }

    @GetMapping
    public List<Performance> getAllPerformance(){
        return performanceService.getAllPerformance();
    }

    @GetMapping("/{id}")
    public Performance getPerformanceById(@PathVariable Long id){
        return performanceService.getPerformanceById(id);
    }

    @PutMapping("/{id}")
    public Performance updatePerformance(@PathVariable Long id,@RequestBody Performance performance){
        return performanceService.updatePerformance(performance,id);
    }

    @DeleteMapping("/{id}")
    public void deletePerformanceById(@PathVariable Long id){
        performanceService.deletePerformanceById(id);
    }

}
