package com.example.kalasethubackend.repository;

import com.example.kalasethubackend.model.Dance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanceRepository extends JpaRepository<Dance, Long> {

    List<Dance> findByDanceNameContainingIgnoreCase(String danceName);
}
