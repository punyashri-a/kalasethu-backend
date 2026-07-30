package com.example.kalasethubackend.model;

import jakarta.persistence.*;
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

