package com.example.kalasethubackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

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
