package com.backend.demo.dto;

import java.util.List;
public class UserInfo {
    private String name;
    private int id;
    private int isClockedIn;

    private String startTime;
    private List<PayHistory> history;


    public UserInfo(String name, int id, int isClockedIn) {
        this.name = name;
        this.id = id;
        this.isClockedIn = isClockedIn;
    }

    public UserInfo(String name, int id, int isClockedIn, String startTime, List<PayHistory> history) {
        this.name = name;
        this.id = id;
        this.isClockedIn = isClockedIn;
        this.startTime = startTime;
        this.history = history;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<PayHistory> getHistory() {
        return history;
    }

    public void setHistory(List<PayHistory> history) {
        this.history = history;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsClockedIn() {
        return isClockedIn;
    }

    public void setIsClockedIn(int isClockedIn) {
        this.isClockedIn = isClockedIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
