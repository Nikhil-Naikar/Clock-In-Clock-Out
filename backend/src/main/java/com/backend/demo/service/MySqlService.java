package com.backend.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MySqlService implements DatabaseService {

    public String test(){
        return "Hello World from MySqlService class";
    }

}
