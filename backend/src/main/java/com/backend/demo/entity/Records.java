package com.backend.demo.entity;

import jakarta.persistence.*;

/**
 * The Records class is built to represent the entity in the local MySQL database.
 * Class variables: represent all the attribute names
 * Class methods: are setters and getters to data retrieval and modification
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

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


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
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
