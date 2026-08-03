package com.example.kalasethubackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceId;
    private String eventName;
    private String venue;
    private String city;
    private LocalDate performanceDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String organizerName;
    private String organizerPhone;
    private double payment;
    private String status;

}
