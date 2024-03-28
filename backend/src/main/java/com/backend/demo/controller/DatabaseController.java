package com.backend.demo.controller;


import com.backend.demo.dto.UserLogInInfo;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/database")
public class DatabaseController {

    private DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @GetMapping("/{pin}/getUsername")
    public String getUsername(@PathVariable int pin){
        return this.databaseService.getName(pin);
    }

    @GetMapping("/{pin}/getUserInfo")
    public UserLogInInfo getUserDetails(@PathVariable int pin){
        return new UserLogInInfo(this.getUsername(pin));
    }



}
