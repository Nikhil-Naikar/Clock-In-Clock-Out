package com.backend.demo.respository;

import com.backend.demo.entity.Records;
import com.backend.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecordsRepo extends JpaRepository<Records, Integer> {

    List<Records> findByPinAndDate(int pin, String date);
    List<Records> findByPin(int pin);
}
