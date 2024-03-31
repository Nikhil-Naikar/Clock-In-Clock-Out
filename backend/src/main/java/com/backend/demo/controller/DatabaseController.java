package com.backend.demo.controller;


import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.UserPin;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DatabaseController {

    private DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @GetMapping("/getUserInfo")
    public UserInfo getUsername(@RequestBody UserPin userPin){
        return this.databaseService.getlogInInfo(userPin.getPin());
    }





}
