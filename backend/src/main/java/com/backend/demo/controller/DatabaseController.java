package com.backend.demo.controller;


import com.backend.demo.entity.Staff;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/test")
    public String test(){
        return this.databaseService.test();
    }

    @GetMapping("/getUsername")
    public List<Staff> getUsername(){
        return this.databaseService.getName(1111);
    }


}
