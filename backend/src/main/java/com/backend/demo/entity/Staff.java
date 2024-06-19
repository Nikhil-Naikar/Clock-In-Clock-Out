package com.backend.demo.entity;


import jakarta.persistence.*;


/**
 * The Staff class is built to represent the entity in the local MySQL database
 * Class variables represent all the attribute names
 * Class methods are setters and getters to data retrieval and modification
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */
@Entity()
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pin;
    private int rate;
    private String role;
    private int clockedIn;

    public int isClockedIn() {
        return clockedIn;
    }

    public void setClockedIn(int clockedIn) {
        this.clockedIn = clockedIn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
