package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HotelMaximumDays {


    public int getMaximum(int[] start, int[] end) {

       int result = 0;

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int maxCount = 0;
        int currCount = 0;

        while (i < start.length && j < end.length) {
            if (start[i] < end[j]) {
                currCount++;
                if (currCount > maxCount) {
                    maxCount = currCount;
                    result = start[i];
                }
                i++;
            } else {
                currCount--;
                j++;
            }
        }
        return result;
    }

    @Test
    public void test_getMaximum() {
        HotelMaximumDays solution = new HotelMaximumDays();
        Assert.assertEquals(5, solution.getMaximum(new int[]{1, 3, 5, 10, 5}, new int[]{3, 5, 12, 12, 9}));
        // [1, 3, 5, 5, 10]
        // [3, 5, 9, 12, 12]
    }
}
