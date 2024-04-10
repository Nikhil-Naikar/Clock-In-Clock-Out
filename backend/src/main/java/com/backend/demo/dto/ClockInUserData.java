package com.backend.demo.dto;

public class ClockInUserData {

    private int pin;
    public String date;
    public String time;

    public ClockInUserData(int pin, String date, String time) {
        this.pin = pin;
        this.date = date;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
