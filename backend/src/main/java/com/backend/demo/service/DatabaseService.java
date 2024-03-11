package com.backend.demo.service;

import java.util.List;

import com.backend.demo.entity.DatabaseTable;

public interface DatabaseService {

    public String test();

    public List<DatabaseTable> getName(int id);
//    public boolean isClockedIn(int id);
//    public void insertClockInTime(String start_time);



}
