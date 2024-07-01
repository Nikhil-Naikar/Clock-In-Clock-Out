package com.backend.demo.controller;

import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.ClockInUserData;
import com.backend.demo.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The DatabaseController is a controller class that create many RESTfull APIs
 * for the frontend application to call upon to interact with the local MySQL database.
 * All end points in this class are accessed under the "/data" path.
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

@RestController
@RequestMapping("/data")
@CrossOrigin("*")
public class DatabaseController {

    private DatabaseService databaseService;

    @Autowired
    public DatabaseController(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    /**
     * Gets a pin and a date, returns the staff's information
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @return UserInfo data transfer object holding all important user data
     * needed by frontend app
     */
    @GetMapping("/getUserInfo/{pin}/{date}")
    public UserInfo getUsername(@PathVariable int pin, @PathVariable String date){
        return this.databaseService.getLogInInfo(pin, date);
    }

    /**
     * Gets a custom object that contains specific information about
     * the staff that is clocking in to start their shift and saves this
     * info in the database
     *
     * @param clockInUserData, a data transfer ClockInUserData object
     */
    @PostMapping("/clock-in")
    public void clockInUser(@RequestBody ClockInUserData clockInUserData){
        this.databaseService.clockingIn(clockInUserData.getPin(), clockInUserData.getDate(), clockInUserData.getTime());
    }

    @PutMapping("/clock-out")
    public void clockOutUser(@RequestBody ClockInUserData clockInUserData){
        this.databaseService.clockingOut(clockInUserData.getPin(), clockInUserData.getDate(), clockInUserData.getTime());
    }

    /**
     * Gets a pin and new status, updates the appropriate record
     * in the database
     *
     * @param pin, a int (dddd)
     * @param status, a int (d)
     */
    @PutMapping("/updateClockInStatus/{pin}/{status}")
    public void updateStatus(@PathVariable int pin, @PathVariable int status){
        this.databaseService.updateStatus(pin, status);
    }







}
