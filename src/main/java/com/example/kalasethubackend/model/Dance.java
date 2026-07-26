package com.example.kalasethubackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Dance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long danceId;
    private String danceName;
    private String duration;
    private String description;
    private boolean active;
}
