package com.example.kalasethubackend.repository;

import com.example.kalasethubackend.model.PerformanceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceAssignmentRepository extends JpaRepository<PerformanceAssignment, Long> {
    List<PerformanceAssignment> findByPerformancePerformanceId(Long performancePerformanceId);

    List<PerformanceAssignment> findByArtistArtistId(Long artistArtistId);

    List<PerformanceAssignment> findByDanceDanceId(Long danceDanceId);

}
