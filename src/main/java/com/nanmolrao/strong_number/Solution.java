package com.nanmolrao.strong_number;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Check the given number is Strong number or not.
 * Strong number is a special number whose sum of factorial of digits is equal to the original number.
 * For example: 145 is strong number. Since, 1! + 4! + 5! = 145
 **/
public class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * Check strong number boolean.
     *
     * @param number the number
     * @return the boolean
     */
    public static boolean checkStrongNumber(Integer number) {
        int sum = 0;
        for(String eachDigit: String.valueOf(number).split("")){
           sum += factorial(Integer.parseInt(eachDigit));
        }
        return sum==number;
    }

    /**
     * Factorial integer.
     *
     * @param num the num
     * @return the integer
     */
    public static Integer factorial(Integer num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static void main(String[] args) {
        log.log(Level.INFO, () -> "Result: " + checkStrongNumber(145));
    }
}
