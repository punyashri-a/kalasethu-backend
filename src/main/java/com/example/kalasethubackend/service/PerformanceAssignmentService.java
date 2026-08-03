package com.example.kalasethubackend.service;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.model.Dance;
import com.example.kalasethubackend.model.Performance;
import com.example.kalasethubackend.model.PerformanceAssignment;
import com.example.kalasethubackend.repository.PerformanceAssignmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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

    public List<PerformanceAssignment> getAllAssignments() {
        return performanceAssignmentRepository.findAll();
    }

    public PerformanceAssignment getAssignmentById(Long assignmentId) {
        return performanceAssignmentRepository.findById(assignmentId).orElse(null);
    }

    public PerformanceAssignment updateAssignment(Long assignmentId, PerformanceAssignment assignment) {
        assignment.setAssignmentId(assignmentId);
        return performanceAssignmentRepository.save(assignment);
    }


    public void deleteAssignment(Long assignmentId) {
         performanceAssignmentRepository.deleteById(assignmentId);
    }

    public List<Artist> getArtistsByPerformance(Long performanceId) {
        List<PerformanceAssignment> performanceAssignments = performanceAssignmentRepository.findByPerformancePerformanceId(performanceId);

        List<Artist> artists = new ArrayList<>();

        for(PerformanceAssignment performanceAssignment : performanceAssignments) {
            artists.add(performanceAssignment.getArtist());
        }

        return artists;
    }

    public List<Dance> getDanceByPerformance(Long performanceId){
        List<PerformanceAssignment> performanceAssignments = performanceAssignmentRepository.findByPerformancePerformanceId(performanceId);

       List<Dance> dances = new ArrayList<>();

       for(PerformanceAssignment performanceAssignment : performanceAssignments){
           dances.add(performanceAssignment.getDance());
       }
       return dances;
    }


    public List<Performance> getPerformanceByArtist(Long artistId){
        List<PerformanceAssignment> performanceAssignments = performanceAssignmentRepository.findByArtistArtistId(artistId);

        List<Performance> performances = new ArrayList<>();

        for(PerformanceAssignment performanceAssignment : performanceAssignments){
            performances.add(performanceAssignment.getPerformance());
        }
        return performances;
    }

    public List<Artist> getArtistByDance(Long danceId){
        List<PerformanceAssignment> performanceAssignments = performanceAssignmentRepository.findByDanceDanceId(danceId);

        List<Artist> artists = new ArrayList<>();

        for(PerformanceAssignment performanceAssignment : performanceAssignments){
            artists.add(performanceAssignment.getArtist());
        }
        return artists;
    }


}
