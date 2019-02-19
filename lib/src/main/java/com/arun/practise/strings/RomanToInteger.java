package com.arun.practise.strings;

import org.junit.Assert;
import org.junit.Test;

public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            int nextValue = i + 1 < s.length() ? getValue(s.charAt(i + 1)) : Integer.MIN_VALUE;

            if (nextValue > value) {
                sum += -value;
            } else {
                sum += value;
            }
        }

        return sum;
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @return
     */
    private int getValue(final char c) {
        int value = Integer.MIN_VALUE;
        switch (c) {
            case 'I':
                value = 1;
                break;
            case 'V':
                value = 5;
                break;
            case 'X':
                value = 10;
                break;
            case 'L':
                value = 50;
                break;
            case 'C':
                value = 100;
                break;
            case 'D':
                value = 500;
                break;
            case 'M':
                value = 1000;
                break;
        }
        return value;
    }

    @Test
    public void test_romanToInt() {
        RomanToInteger solution = new RomanToInteger();
        Assert.assertEquals(3, solution.romanToInt("III"));
        Assert.assertEquals(4, solution.romanToInt("IV"));
        Assert.assertEquals(9, solution.romanToInt("IX"));
        Assert.assertEquals(58, solution.romanToInt("LVIII"));
        Assert.assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }
}
