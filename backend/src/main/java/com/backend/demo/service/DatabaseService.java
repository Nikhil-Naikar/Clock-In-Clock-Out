package com.backend.demo.service;

import java.util.List;
import com.backend.demo.dto.UserInfo;

public interface DatabaseService {

    public String getName(int id);
    public int isUserClockedIn(int id);
    public int getId(int pin);
    public UserInfo getlogInInfo(int pin);
//    public List<History> getHistory(int id);
//    public boolean isClockedIn(int id);

//    public void insertClockInTime(String start_time);



}
