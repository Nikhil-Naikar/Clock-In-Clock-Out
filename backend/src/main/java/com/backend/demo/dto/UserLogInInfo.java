package com.backend.demo.dto;

public class UserLogInInfo {
    private String name;

    public UserLogInInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
