package com.nanmolrao.minimum_no_of_platforms;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * find minimum number of platform required to arrange 6 trains.
 * Input: arrival_time[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}
 * departure_time[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 **/

public class Solution {

    static Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * @param arrivalTime - Array of arrival time of 6 trains
     * @param departureTime - Array of departure time of 6 trains
     * @return - Minimum number of platforms required.
     */
    public static Integer worker(String[] arrivalTime, String[] departureTime) {
        Integer minimumPlatforms = 1;
        int size = departureTime.length;
        Integer[] arrivals = new Integer[size];
        Integer[] departures = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrivals[i] = toSeconds(arrivalTime[i]);
            departures[i] = toSeconds(departureTime[i]);
        }
        int i = 0;
        int j = 1;
        while (i < size && j < size) {
            if (arrivals[j] <= departures[i]) {
                minimumPlatforms++;
                j++;
            }else{
                minimumPlatforms--;
                i++;
            }
        }
        return minimumPlatforms;
    }

    /**
     * @param timeString - String value of a time int the format "HH:MM"
     * @return - Time string converted to seconds
     */
    public static Integer toSeconds(String timeString) {
        return (Integer.parseInt(timeString.split(":")[0]) * 3600)
                + (Integer.parseInt(timeString.split(":")[1]) * 60);
    }

    public static void main(String[] args) {
        String[] arrivalTime = {"9:00", "9:40", "9:50", "11:00", "15:00", "18:00" };
        String[] departureTime = {"9:10", "12:00", "11:20", "11:30", "19:00", "20:00" };
        log.log(Level.INFO, () -> "Minimum Platforms required: " + worker(arrivalTime, departureTime));
    }
}
