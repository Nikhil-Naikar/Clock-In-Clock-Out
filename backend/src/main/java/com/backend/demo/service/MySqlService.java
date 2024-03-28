package com.backend.demo.service;

import java.util.List;

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


}
