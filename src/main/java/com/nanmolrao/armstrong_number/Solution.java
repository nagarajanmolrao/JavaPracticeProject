package com.nanmolrao.armstrong_number;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Print all Armstrong numbers between 1 and 1000.
 * An Armstrong number is an n-digit number that is equal to the sum of nth power of its digits. For example,
 * 6 = 6^1 = 6
 * 371 = 3^3 + 7^3 + 1^3 = 371
 **/
public class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * Get armstrong numbers string.
     *
     * @return the string of armstrong numbers between 1 and 1000
     */
    public static String getArmstrongNumbers() {
        StringBuilder returnString = new StringBuilder();
        for (int i = 1; i <= 1000; i++) {
            if (checkForArmstrongNumber(i)) {
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
    public static boolean checkForArmstrongNumber(Integer number) {
        int n = String.valueOf(number).length();
        double sum = 0D;
        for (String eachDigit : String.valueOf(number).split("")) {
            sum += Math.pow(Double.parseDouble(eachDigit), n);
        }
        return number == (int) sum;
    }

    /**
     * Get armstrong numbers between 1 and 1000 using streams.
     *
     * @return the string of armstrong numbers between 1 and 1000
     */
    public static String getArmstrongNumbersV2() {
        return IntStream.rangeClosed(1, 1000)
                .filter(number -> {
                    int n = String.valueOf(number).length();
                    double sum = Arrays.stream(String.valueOf(number).split(""))
                            .mapToDouble(Integer::parseInt)
                            .map(digit -> Math.pow(digit, n))
                            .sum();
                    return number == (int) sum;
                })
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        log.log(Level.INFO, () -> "Armstrong numbers between 1 and 1000:\n" + getArmstrongNumbers());
        log.log(Level.INFO, () -> "Armstrong numbers between 1 and 1000(with streams):\n" + getArmstrongNumbersV2());
    }
}
