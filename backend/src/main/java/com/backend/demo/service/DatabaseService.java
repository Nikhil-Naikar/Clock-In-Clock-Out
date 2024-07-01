package com.backend.demo.service;

import java.util.List;
import com.backend.demo.dto.PayHistory;
import com.backend.demo.dto.UserInfo;
import com.backend.demo.entity.Records;

/**
 * The DatabaseService interface contains several methods to interact with the
 * local MySQL database and is a contract for any class than implements this interface,
 * setting a rule that the class MUST define these methods. This design purpose is choice
 * is future ease for extension for future development and to have polymorphism following
 * good OOP practices
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

public interface DatabaseService {

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get name attribute value
     *
     * @param pin, a int (dddd)
     * @return a String holds the name of the user
     */
    public String getName(int pin);

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get ClockedIn attribute value
     *
     * @param pin, a int (dddd)
     * @return int holds the ClockedIn value
     */
    public int isUserClockedIn(int pin);

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get id attribute value
     *
     * @param pin, a int (dddd)
     * @return int holds the id value
     */
    public int getId(int pin);

    /**
     * Gets a pin and date, uses this to query the database to get
     * the user data
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @return UserInfo data transfer object holding all important user data
     * needed by frontend app
     */
    public UserInfo getLogInInfo(int pin, String date);

    /**
     * Gets a pin and date, uses this to query the Records table,
     * to get time when a specific staff started their shift
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @return String, return the start time of the shift of a specific staff
     */
    public String getStartTime(int pin, String date);

    /**
     * Gets a pin, uses this to query the Records table, to get
     * all the matching rows that is the work history of a
     * specific user
     *
     * @param pin, a int (dddd)
     * @return PayHistory, a data transfer object, returns all the
     * important data for the shift history of a specific staff to
     * the frontend app
     */
    public List<PayHistory>  getPayHistory(int pin);

    /**
     * Add a record to the Records table, containing details
     * about a staff clocking in
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @param time, a String
     */
    public void clockingIn(int pin, String date, String time);

    /**
     * Updates a record from the Records table, add the end time,
     * calculates the daily wage by looking up the rate in the staff
     * table and determine the hours of the shift
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @param time, a String
     */
    public void clockingOut(int pin, String date, String time);

    /**
     * Updates the clockedIn attribute of the record in the Staff
     * table that matches the pin attribute
     *
     * @param pin, a int (dddd)
     * @param newStatus, a int (d)
     */
    public void updateStatus(int pin, int newStatus);

    /**
     * Locates all records matching pin in records table
     *
     * @param pin, a int (dddd)
     */
    public List<Records> employeeHistory (int pin);



}
