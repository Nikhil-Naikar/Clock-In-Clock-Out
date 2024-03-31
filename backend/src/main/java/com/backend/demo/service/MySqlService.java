package com.backend.demo.service;

import java.util.List;
import java.util.ArrayList;
import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.PayHistory;
import com.backend.demo.entity.Staff;
import com.backend.demo.entity.Records;
import com.backend.demo.respository.UsersRepo;
import com.backend.demo.respository.RecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlService implements DatabaseService {

    @Autowired
    private UsersRepo usersRepository;
    @Autowired
    private RecordsRepo recordsRepository;


    public String test(){
        return "Hello World from MySqlService class";
    }

    public String getName(int id){
        List<Staff> staffRow = usersRepository.findByPin(id);
        if (staffRow.isEmpty()){
            return null;
        }
        return staffRow.get(0).getName();
    }

    public int isUserClockedIn(int id){
        List<Staff> staffRow = usersRepository.findByPin(id);
        return staffRow.get(0).isClockedIn();
    }

    public int getId(int pin){
        List<Staff> staffRow = usersRepository.findByPin(pin);
        return staffRow.get(0).getId();
    }

    public UserInfo getlogInInfo(int pin, String date){
        String name = this.getName(pin);
        if (name == null){
            return null;
        }
        int isClockedIn = this.isUserClockedIn(pin);
        int id = this.getId(pin);
        String time = this.getStartTime(pin, date);
        List<PayHistory> history = getPayHistory(pin);
        return new UserInfo(name, id, isClockedIn, time, history);
    }

    public String getStartTime(int pin, String date){
        List<Records> recordsRow = recordsRepository.findByPinAndDate(pin, date);
        if (recordsRow.isEmpty()){
            return null;
        }
        return recordsRow.get(0).getStart_time();
    }

    public List<PayHistory> getPayHistory(int pin){
        List<Records> recordsRows =  recordsRepository.findByPin(pin);
        List<PayHistory> res = new ArrayList<PayHistory>();
        for (Records record : recordsRows){
            res.add(new PayHistory(record.getDate(), record.getStart_time(), record.getEnd_time(), record.getHours(), record.getDaily_wage()));
        }
        return res;
    }


}
