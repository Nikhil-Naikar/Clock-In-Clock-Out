package com.backend.demo.respository;

import com.backend.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    List<Staff> findByPin(int pin);


    @Query(value = "UPDATE Staff r SET clockedIn=?2 WHERE pin=?1", nativeQuery = true)
    void updateClockedInStatus(int pin, int newStatus);
}
