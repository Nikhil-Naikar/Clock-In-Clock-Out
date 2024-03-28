package com.backend.demo.respository;

import com.backend.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsersRepo extends JpaRepository<Staff, Integer> {

    List<Staff> findByPin(int pin);
}
