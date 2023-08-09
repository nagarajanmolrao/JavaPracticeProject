package com.nanmolrao.perfect_number;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Print all perfect numbers between 1 and 100.
 * exp: Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
 * For example: 6 is the first perfect number
 * Proper divisors of 6 are 1, 2, 3
 * Sum of its proper divisors = 1 + 2 + 3 = 6.
 * Hence, 6 is a perfect number.
 **/

public class Solution {

    public static final Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * @return - A space delimited string containing perfect numbers between 1 and 100
     */
    public static String findPerfectNumber() {
        StringBuilder perfectNumbers = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            if (perfectNumberCheck(i)) {
                perfectNumbers.append(i);
                perfectNumbers.append(" ");
            }
        }
        return perfectNumbers.toString();
    }

    /**
     *
     * @param number - Number which is to be checked whether it is a perfect number
     * @return - returns true if the given number is a perfect number, else returns false
     */
    public static boolean perfectNumberCheck(Integer number) {
        int total = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                total += i;
            }
        }
        return total == number;
    }

    /**
     * @return - A space delimited string containing perfect numbers between 1 and 100
     */
    public static String findPerfectNumberV2(){
        return IntStream.rangeClosed(1, 100)
                .filter(Solution::perfectNumberCheckV2)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
    }

    /**
     *
     * @param number - Number which is to be checked whether it is a perfect number
     * @return - returns true if the given number is a perfect number, else returns false
     */
    public static boolean perfectNumberCheckV2(Integer number){
        int total = IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum();
        return total == number;
    }

    public static void main(String[] args) {
        log.log(Level.INFO, ()-> "findPerfectNumber(): " + findPerfectNumber());
        log.log(Level.INFO, ()-> "findPerfectNumberV2(): " + findPerfectNumberV2());
    }
}
