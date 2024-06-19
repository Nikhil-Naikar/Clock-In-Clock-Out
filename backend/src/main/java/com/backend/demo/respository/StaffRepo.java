package com.backend.demo.respository;

import com.backend.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The StaffRepo class is built to read and manipulate the data in the Staff entity in the local MySQL database
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

public interface StaffRepo extends JpaRepository<Staff, Integer> {

    /**
     * Receives a pin, then queries the Staff table to get all the records
     * with the matching rows than have the matching pin attribute
     *
     * @param pin, an int (dddd)
     * @return return a Staff list of the matching queries as mentioned above
     */
    List<Staff> findByPin(int pin);

    /**
     * Receives a pin and newStatus, updates newStatus of the row that has
     * the matching pin
     *
     * @param pin, an int (dddd)
     * @param newStatus, an int (d)
     */
    @Modifying
    @Query("UPDATE Staff r SET r.clockedIn = :newStatus WHERE r.pin = :pin")
    void updateClockedInStatus(@Param("pin") int pin, @Param("newStatus") int newStatus);

}
