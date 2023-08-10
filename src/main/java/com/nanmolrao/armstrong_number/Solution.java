package com.nanmolrao.armstrong_number;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Print all Armstrong number between 1 and 1000.
 * An Armstrong number is an n-digit number that is equal to the sum of nth power of its digits. For example,
 * 6 = 61 = 6
 * 371 = 33 + 73 + 13 = 371
 **/
public class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * Get armstrong numbers string.
     *
     * @return the string of armstrong numbers between 1 and 1000
     */
    public static String getArmstrongNumbers(){
        StringBuilder returnString = new StringBuilder();
        for(int i = 1;i<=1000;i++){
            if(checkForArmstrongNumber(i)){
                returnString.append(i);
                returnString.append(" ");
            }
        }
        return returnString.toString();
    }

    /**
     * Check for armstrong number boolean.
     *
     * @param number the number to be checked
     * @return returns true if the number is Armstrong number, else returns false
     */
    public static boolean checkForArmstrongNumber(Integer number){
        int n = String.valueOf(number).length();
        double sum = 0D;
        for(String eachDigit: String.valueOf(number).split("")){
            sum += Math.pow(Double.parseDouble(eachDigit), n);
        }
        return number == (int) sum;
    }

    public static void main(String[] args) {
        log.log(Level.INFO, ()->"Armstrong numbers between 1 and 1000:\n" + getArmstrongNumbers());
    }
}
