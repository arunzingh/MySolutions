package com.arun.practise.strings;

import org.junit.Assert;
import org.junit.Test;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer(s.length());
        if (s == null || s.length() == 0) {
            return result.toString();
        }

        if (numRows == 1) {
            return s;
        }

        int interval = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += interval) {
                result.append(s.charAt(i + j));

                if (i > 0 && i < numRows - 1 && j + interval - i < s.length()) {
                    result.append(s.charAt(j + interval - i));
                }
            }
        }

        return result.toString();
    }

    @Test
    public void test_convert() {
        ZigZagConversion solution = new ZigZagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }
}
