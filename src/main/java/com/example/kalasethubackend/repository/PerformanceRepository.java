package com.example.kalasethubackend.repository;

import com.example.kalasethubackend.model.Artist;
import com.example.kalasethubackend.model.Performance;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    List<Performance> findByCity(String city);

    List<Performance> findByStatus(String status);


}
