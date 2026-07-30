package com.example.kalasethubackend.repository;

import com.example.kalasethubackend.model.PerformanceAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceAssignmentRepository extends JpaRepository<PerformanceAssignment, Long> {
}
