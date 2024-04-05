package com.backend.demo.controller;

import com.backend.demo.dto.UserInfo;
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







}
