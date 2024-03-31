package com.backend.demo.service;

import java.util.List;

import com.backend.demo.dto.PayHistory;
import com.backend.demo.dto.UserInfo;


public interface DatabaseService {

    public String getName(int id);
    public int isUserClockedIn(int id);
    public int getId(int pin);
    public UserInfo getlogInInfo(int pin, String date);
    public String getStartTime(int pin, String date);

    public List<PayHistory>  getPayHistory(int pin);




}
