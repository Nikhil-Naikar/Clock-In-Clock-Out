package com.backend.demo.dto;

public class UserInfo {
    private String name;
    private int id;
    private int isClockedIn;


    public UserInfo(String name, int id, int isClockedIn) {
        this.name = name;
        this.id = id;
        this.isClockedIn = isClockedIn;
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
