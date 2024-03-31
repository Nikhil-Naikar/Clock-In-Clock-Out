package com.backend.demo.service;

import java.util.List;

import com.backend.demo.dto.UserInfo;
import com.backend.demo.entity.Staff;
import com.backend.demo.respository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlService implements DatabaseService {

    @Autowired
    private UsersRepo usersRepository;


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

    public UserInfo getlogInInfo(int pin){
        String name = this.getName(pin);
        if (name == null){
            return null;
        }
        int isClockedIn = this.isUserClockedIn(pin);
        int id = this.getId(pin);
        UserInfo res = new UserInfo(name, id, isClockedIn);
        return res;
    }

}
