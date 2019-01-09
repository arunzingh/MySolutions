package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private final Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int a) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int b = entry.getKey();
            int value = a - b;

            if (b == value && entry.getValue() > 1 || b != value && map.containsKey(value))
                return true;
        }

        return false;
    }

    @Test
    public void test_TwoSum() {
        TwoSum solution = new TwoSum();
        solution.add(3);
        solution.add(2);
        solution.add(1);

        Assert.assertEquals(false, solution.find(2));

    }

    @Test
    public void test_TwoSum_Single0() {
        TwoSum solution = new TwoSum();
        solution.add(0);

        Assert.assertEquals(false, solution.find(0));
    }

    @Test
    public void test_TwoSum_Two0s() {
        TwoSum solution = new TwoSum();
        solution.add(0);
        solution.add(0);

        Assert.assertEquals(true, solution.find(0));
    }

    @Test
    public void test_TwoSum_PositiveNegative() {
        TwoSum solution = new TwoSum();
        solution.add(7);
        solution.add(-7);

        Assert.assertEquals(true, solution.find(0));
    }


    @Test
    public void test_TwoSum_TestCase1() {
        TwoSum solution = new TwoSum();
        solution.add(0);
        solution.add(-1);
        solution.add(1);

        Assert.assertEquals(true, solution.find(0));
    }
}
