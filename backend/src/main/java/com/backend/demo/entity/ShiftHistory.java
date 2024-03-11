package com.backend.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "shift_history")
public class ShiftHistory extends DatabaseTable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String start_time;
    private String end_time;
    private int daily_wage;
    private int rating;
    private String feedback;

}
