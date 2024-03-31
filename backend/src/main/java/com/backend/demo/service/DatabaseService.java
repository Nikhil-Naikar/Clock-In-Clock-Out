package com.backend.demo.service;

import java.util.List;
import com.backend.demo.dto.UserInfo;
import com.backend.demo.entity.Records;

public interface DatabaseService {

    public String getName(int id);
    public int isUserClockedIn(int id);
    public int getId(int pin);
    public UserInfo getlogInInfo(int pin);
    public String getStartTime(int pin, String date);

    public List<Records> getPayHistory(int pin);




}
