package com.backend.demo.dto;

public class PayHistory {
    private String date;
    private String startTime;
    private String endTime;
    private double hours;
    private int dailyWage;

    public PayHistory(String date, String startTime, String endTime, double hours, int dailyWage) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hours = hours;
        this.dailyWage = dailyWage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(int dailyWage) {
        this.dailyWage = dailyWage;
    }
}
