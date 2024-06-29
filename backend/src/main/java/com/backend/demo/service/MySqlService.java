package com.backend.demo.service;

import java.util.List;
import java.util.ArrayList;
import com.backend.demo.dto.UserInfo;
import com.backend.demo.dto.PayHistory;
import com.backend.demo.entity.Staff;
import com.backend.demo.entity.Records;
import com.backend.demo.respository.StaffRepo;
import com.backend.demo.respository.RecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The MySQLService is a service class contains the implementation for
 * several methods that are defined the DatabaseService interface which
 * this class implements
 *
 * @author Nikhil Naikar
 * @version 1.0
 * @since Dec.5,2023
 */

@Service
public class MySqlService implements DatabaseService {

    @Autowired
    private StaffRepo staffRepository;
    @Autowired
    private RecordsRepo recordsRepository;

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get name attribute value
     *
     * @param pin, a int (dddd)
     * @return a String holds the name of the user
     */
    public String getName(int pin){
        List<Staff> staffRow = staffRepository.findByPin(pin);
        if (staffRow.isEmpty()){
            return null;
        }
        return staffRow.get(0).getName();
    }

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get ClockedIn attribute value
     *
     * @param pin, a int (dddd)
     * @return int holds the ClockedIn value
     */
    public int isUserClockedIn(int pin){
        List<Staff> staffRow = staffRepository.findByPin(pin);
        return staffRow.get(0).isClockedIn();
    }

    /**
     * Queries the Staff table, get row with matching pin attribute,
     * uses getter to get id attribute value
     *
     * @param pin, a int (dddd)
     * @return int holds the id value
     */
    public int getId(int pin){
        List<Staff> staffRow = staffRepository.findByPin(pin);
        return staffRow.get(0).getId();
    }

    /**
     * Gets a pin and date, uses this to query the database to get
     * the user data
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @return UserInfo data transfer object holding all important user data
     * needed by frontend app
     */
    public UserInfo getLogInInfo(int pin, String date){
        String name = this.getName(pin);
        if (name == null){
            return null;
        }
        int isClockedIn = this.isUserClockedIn(pin);
        int id = this.getId(pin);
        String time = this.getStartTime(pin, date);
        List<PayHistory> history = getPayHistory(pin);
        return new UserInfo(name, id, isClockedIn, time, history);
    }

    /**
     * Gets a pin and date, uses this to query the Records table,
     * to get time when a specific staff started their shift
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @return String, return the start time of the shift of a specific staff
     */
    public String getStartTime(int pin, String date){
        List<Records> recordsRow = recordsRepository.findByPinAndDate(pin, date);
        if (recordsRow.isEmpty()){
            return null;
        }
        return recordsRow.get(0).getStart_time();
    }

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
    public List<PayHistory> getPayHistory(int pin){
        List<Records> recordsRows =  recordsRepository.findByPin(pin);
        List<PayHistory> res = new ArrayList<PayHistory>();
        for (Records record : recordsRows){
            res.add(new PayHistory(record.getDate(), record.getStart_time(), record.getEnd_time(), record.getHours(), record.getDaily_wage()));
        }
        return res;
    }

    /**
     * Add a record to the Records table, containing details
     * about a staff clocking in
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @param time, a String
     */
    public void clockingIn(int pin, String date, String time){
        Records newRecord = new Records();
        newRecord.setPin(pin);
        newRecord.setDate(date);
        newRecord.setStart_time(time);
        recordsRepository.save(newRecord);
    }

    /**
     * Updates a record from the Records table, add the end time,
     * calculates the daily wage by looking up the rate in the staff
     * table and determine the hours of the shift
     *
     * @param pin, a int (dddd)
     * @param date, a String
     * @param endTime, a String
     */
    public void clockingOut(int pin, String date, String endTime){
        int hourlyRate = staffRepository.findByPin(pin).get(0).getRate();
        Records existingRecord = recordsRepository.findByPinAndDate(pin, date).get(0);
        if (existingRecord != null) {
            String startTime = existingRecord.getStart_time();
            double[] temp = this.calculateWage(startTime, endTime, hourlyRate);
            recordsRepository.updateRecord(pin, date, endTime, temp[1], (int) temp[0]);
            System.out.println("I MADE IT HERE!!!!!!!!!!!!!!!!!!!!!!!");
        }

    }

    /**
     * Logic for calculating the daily wage
     *
     * @param startTime, a String
     * @param endTime, a String
     * @param hourlyRate, an int
     */
    public double[] calculateWage(String startTime, String endTime, int hourlyRate){
        String[] startParts = startTime.split(":");
        int startHours = Integer.parseInt(startParts[0]);
        int startMinutes = Integer.parseInt(startParts[1]);

        String[] endParts = endTime.split(":");
        int endHours = Integer.parseInt(endParts[0]);
        int endMinutes = Integer.parseInt(endParts[1]);

        int totalStartMinutes = startHours * 60 + startMinutes;
        int totalEndMinutes = endHours * 60 + endMinutes;

        int totalMinutesDifference;
        if (totalEndMinutes >= totalStartMinutes) {
            totalMinutesDifference = totalEndMinutes - totalStartMinutes;
        } else {
            totalMinutesDifference = (24 * 60 - totalStartMinutes) + totalEndMinutes;
        }

        double shiftTime = (double) totalMinutesDifference / 60;
        double wage =  shiftTime * hourlyRate;

        double temp [] = {wage,shiftTime};
        return temp;

    }



    /**
     * Updates the clockedIn attribute of the record in the Staff
     * table that matches the pin attribute
     *
     * @param pin, a int (dddd)
     * @param newStatus, a int (d)
     */
    @Transactional
    public void updateStatus(int pin, int newStatus){
        staffRepository.updateClockedInStatus(pin, newStatus);
    }


}
