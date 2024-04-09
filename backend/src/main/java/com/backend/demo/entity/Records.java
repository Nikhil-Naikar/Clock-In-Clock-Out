package com.backend.demo.entity;

import jakarta.persistence.*;

@Entity()
@Table(name = "records")
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generatedId;
    private int pin;
    private String date;
    private String start_time;
    private String end_time;
    private int daily_wage;
    private int rating;
    private int hours;
    private String feedback;

    public Records(int pin, String date, String start_time) {
        this.pin = pin;
        this.date = date;
        this.start_time = start_time;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int id) {
        this.pin = pin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getDaily_wage() {
        return daily_wage;
    }

    public void setDaily_wage(int daily_wage) {
        this.daily_wage = daily_wage;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
