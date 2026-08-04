package com.example.kalasethubackend.service;

import com.example.kalasethubackend.model.Dance;
import com.example.kalasethubackend.repository.DanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DanceService {
    private final DanceRepository danceRepository;

    public DanceService(DanceRepository danceRepository) {
        this.danceRepository = danceRepository;
    }

    public Dance addDance(Dance dance) {
        return danceRepository.save(dance);
    }

    public List<Dance> getAllDances() {
        return danceRepository.findAll();
    }

    public Dance getDanceById(Long id) {
        return danceRepository.findById(id).orElse(null);
    }

    public Dance updateDanceById(@PathVariable Long id, @RequestBody Dance dance) {
        dance.setDanceId(id);
        return danceRepository.save(dance);
    }

    public void deleteDanceById(@PathVariable Long id) {
        danceRepository.deleteById(id);
    }

    public List<Dance> searchDanceByName(String danceName){
        return danceRepository.findByDanceNameContainingIgnoreCase(danceName);
    }
}
