package com.example.kalasethubackend.controller;

import com.example.kalasethubackend.model.Dance;
import com.example.kalasethubackend.service.DanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/dances")
public class DanceController {
    private final DanceService danceService;

    public DanceController(DanceService danceService) {
        this.danceService = danceService;
    }

    @PostMapping
    public Dance addDance(@Valid @RequestBody Dance dance){
        return danceService.addDance(dance);
    }

    @GetMapping
    public List<Dance> getAllDances(){
        return danceService.getAllDances();
    }

    @GetMapping("/{id}")
    public Dance getDanceById(@PathVariable Long id){
        return danceService.getDanceById(id);
    }

    @PutMapping("/{id}")
    public Dance updateDanceById(@PathVariable Long id,@Valid @RequestBody Dance dance){
        return danceService.updateDanceById(id,dance);
    }

    @DeleteMapping("/{id}")
    public void deleteDanceById(@PathVariable Long id){
        danceService.deleteDanceById(id);
    }

    @GetMapping("/search/{danceName}")
    public List<Dance> searchDanceByName(@PathVariable String danceName){
        return danceService.searchDanceByName(danceName);
    }
}
