package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class KEmptySlots {

    public int kEmptySlots(int[] flowers, int k) {
        int day = 0;
        if (flowers == null || flowers.length == 0) {
            return day;
        }
        int[] state = new int[flowers.length];

        while (day < flowers.length) {
            int position = flowers[day];
            state[position - 1] = 1;

            int index = 0;

            while (index < state.length) {
                while (index < state.length && state[index] == 0) {
                    index++;
                }

                int onesCount = 0;
                while (index < state.length && state[index] == 1) {
                    onesCount++;
                    index++;
                }

                if (k == 0 && onesCount > 1) {
                    return day + 1;
                }

                int start = index;
                index++;

                while (index < state.length && state[index] == 0) {
                    index++;
                }
                if (index >=  state.length) {
                    break;
                }
                int end = index;
                int count = end - start;

                if (count == k)
                    return day + 1;

            }

            day++;
        }

        return -1;
    }

    @Test
    public void test_kEmptySlots() {
        KEmptySlots solution = new KEmptySlots();
        Assert.assertEquals(2, solution.kEmptySlots(new int[]{1, 3, 2}, 1));
    }

    @Test
    public void test_kEmptySlots_t2() {
        KEmptySlots solution = new KEmptySlots();
        Assert.assertEquals(-1, solution.kEmptySlots(new int[]{1, 2, 3}, 1));
    }

    @Test
    public void test_kEmptySlots_t3() {
        KEmptySlots solution = new KEmptySlots();
        Assert.assertEquals(2, solution.kEmptySlots(new int[]{1, 2, 3}, 0));
    }
}
