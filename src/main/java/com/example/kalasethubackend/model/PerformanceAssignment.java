package com.example.kalasethubackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PerformanceAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "performanceId")
    private Performance performance;

    @ManyToOne
    @JoinColumn(name = "danceId")
    private Dance dance;

    @ManyToOne
    @JoinColumn(name = "artistId")
    private  Artist artist;

}
