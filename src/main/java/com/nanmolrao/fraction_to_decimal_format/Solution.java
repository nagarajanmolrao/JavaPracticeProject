package com.nanmolrao.fraction_to_decimal_format;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implement the method that provided numerator and denominator will
 * return a string representing fraction's decimal form.
 * Some fractions in decimal form have cyclic decimal points.
 * Examples:
 * 1/2 = 0.5
 * 1/3 = 0.(3)
 **/
public class Solution {
    public static final Logger log = Logger.getLogger(Solution.class.getName());

    /**
     * Convert fraction to decimal string.
     *
     * @param fraction the fraction in "numerator/denominator"
     * @return the decimal string
     */
    public static String convertFractionToDecimalString(String fraction) {
        String[] numbers = fraction.split("/");
        int numerator = Integer.parseInt(numbers[0]);
        int denominator = Integer.parseInt(numbers[1]);
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder resultString = new StringBuilder();
        resultString.append(numerator / denominator);
        numerator %= denominator;
        if (numerator == 0) {
            return resultString.toString();
        }
        resultString.append(".");
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        while (numerator != 0) {
            numerator *= 10;
            resultString.append(numerator / denominator);
            numerator %= denominator;
            if (resultMap.containsKey(numerator)) {
                int index = resultMap.get(numerator);
                resultString.insert(index-1, "(");
                resultString.append(")");
                break;
            } else {
                resultMap.put(numerator, resultString.length());
            }
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        log.log(Level.INFO, () -> convertFractionToDecimalString("1/3"));
        log.log(Level.INFO, () -> convertFractionToDecimalString("22/7"));
    }
}
