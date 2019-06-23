package com.arun.practise.dp;

import org.junit.Assert;
import org.junit.Test;

public class Tiling {

    /**
     * https://www.spoj.com/problems/GNY07H/
     *
     * @param n
     * @return
     */
    public int countWaysDominos(int n) {

    }


    @Test
    public void test_countWaysDominos() {
        Tiling solution = new Tiling();
    }


    /**
     *
     * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1300
     *
     * @param n
     * @return
     */
    public int countWays(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 3;
        }

        return countWays(n - 1) + 2 * countWays(n - 2);
    }

    @Test
    public void test_countWays() {
        Tiling solution = new Tiling();
        Assert.assertEquals(3, solution.countWays(2));
        Assert.assertEquals(5, solution.countWays(3));
        Assert.assertEquals(171, solution.countWays(8));
        Assert.assertEquals(2731, solution.countWays(12));
    }

}
