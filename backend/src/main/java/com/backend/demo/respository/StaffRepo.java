package com.backend.demo.respository;

import com.backend.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    List<Staff> findByPin(int pin);

    @Modifying
    @Query("UPDATE Staff r SET r.clockedIn = :newStatus WHERE r.pin = :pin")
    void updateClockedInStatus(@Param("pin") int pin, @Param("newStatus") int newStatus);

}
