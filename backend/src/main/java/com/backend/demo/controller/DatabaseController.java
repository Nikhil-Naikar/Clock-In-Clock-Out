package com.backend.demo.controller;

import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.ClockInUserData;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@CrossOrigin("*")
public class DatabaseController {

    private DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @GetMapping("/getUserInfo/{pin}/{date}")
    public UserInfo getUsername(@PathVariable int pin, @PathVariable String date){
        return this.databaseService.getlogInInfo(pin, date);
    }

    @PostMapping("/ClockInUser")
    public void userClockingIn(@RequestBody ClockInUserData clockInUserData){
        this.databaseService.clockingIn(clockInUserData.getPin(), clockInUserData.getDate(), clockInUserData.getTime());
    }

    @PutMapping("/updateClockInStatus/{pin}/{status}")
    public void updateStatus(@PathVariable int pin, @PathVariable int status){
        this.databaseService.updateStatus(pin, status);
    }







}
