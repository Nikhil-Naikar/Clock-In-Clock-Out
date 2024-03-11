package com.backend.demo.respository;

import com.backend.demo.entity.Staff;
import com.backend.demo.entity.DatabaseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersRepository extends JpaRepository<Staff, Integer> {

    List<DatabaseTable> findByPin(int pin);
}
