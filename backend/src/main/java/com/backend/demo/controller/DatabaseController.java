package com.backend.demo.controller;


import com.backend.demo.dto.PayHistory;
import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.CheckUser;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/data")
@CrossOrigin("*")
public class DatabaseController {

    private DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @GetMapping("/getUserInfo")
    public UserInfo getUsername(@RequestBody CheckUser checkUser){
        return this.databaseService.getlogInInfo(checkUser.getPin(), checkUser.getDate());
    }







}
