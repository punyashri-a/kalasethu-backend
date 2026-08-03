package com.example.kalasethubackend.service;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.model.Performance;
import com.example.kalasethubackend.repository.PerformanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    PerformanceRepository performanceRepository;

    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public Performance addPerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    public List<Performance> getAllPerformance() {
        return performanceRepository.findAll();
    }

    public Performance getPerformanceById(Long id) {
        return performanceRepository.findById(id).orElse(null);
    }

    public Performance updatePerformance(Performance performance, Long id) {
        performance.setPerformanceId(id);
        return performanceRepository.save(performance);

    }

    public void deletePerformanceById(Long id) {
        performanceRepository.deleteById(id);
    }

    public List<Performance> getPerformanceByCity(String city){
        return performanceRepository.findByCity(city);
    }

    public List<Performance> getPerformanceByStatus(String status){
        return performanceRepository.findByStatus(status);
    }

}
