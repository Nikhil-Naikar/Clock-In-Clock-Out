package com.backend.demo.service;

import java.util.List;
import com.backend.demo.entity.DatabaseTable;
import com.backend.demo.respository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySqlService implements DatabaseService {

    @Autowired
    private UsersRepository usersRepository;

    public String test(){
        return "Hello World from MySqlService class";
    }

    public List<DatabaseTable> getName(int id){
        return usersRepository.findByPin(id);
    }

}
