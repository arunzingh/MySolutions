package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

public class BuySellStock {

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction
     * (i.e., buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfitSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfitSoFar;
    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     * <p>
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxProfitSoFar = 0;

        if (prices == null || prices.length == 0) return maxProfitSoFar;


        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxProfitSoFar += prices[i + 1] - prices[i];
            }
        }

        return maxProfitSoFar;
    }

    public int maxProfit2UsingDp(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int cash = 0; // sell if you see profit
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i]);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p>
     * Note: You may not engage in multiple transactions at the same time
     * (i.e., you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [3,3,5,0,0,3,1,4]
     * Output: 6
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     * Example 2:
     * <p>
     * Input: [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
     * engaging multiple transactions at the same time. You must sell before buying again.
     * Example 3:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *
     * @param price
     * @return
     */
    public int maxProfit3(int[] price) {

        int maxProfit = 0;

        if (price == null || price.length == 0) {
            return maxProfit;
        }

        // max profit from 0 to i
        int[] left = new int[price.length];
        // max profit from i to prices.length - 1
        int[] right = new int[price.length];


        int min = price[0];
        int maxLeftSoFar = Integer.MIN_VALUE;
        for (int i = 1; i < price.length; i++) {
            min = Math.min(min, price[i]);
            maxLeftSoFar = Math.max(maxLeftSoFar, price[i] - min);
            left[i] = maxLeftSoFar;
        }


        int max = price[price.length - 1];
        int maxRightSoFar = Integer.MIN_VALUE;
        for (int i = price.length - 2; i >= 0; i--) {
            max = Math.max(max, price[i]);
            maxRightSoFar = Math.max(maxRightSoFar, max - price[i]);
            right[i] = maxRightSoFar;
        }

        for (int i = 0; i < price.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * <p>
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * <p>
     * Example 1:
     * <p>
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:
     * <p>
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     *
     * @param price
     * @return
     */
    public int maxProfit4SlowSolution(int[] price, int k) {
        if (price == null || price.length == 0) return 0;

        int T[][] = new int[k + 1][price.length];

        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < price.length; j++) {
                int maxPreviousSFar = Integer.MIN_VALUE;
                for (int m = 0; m < j; m++) {
                    maxPreviousSFar = Math.max(maxPreviousSFar, price[j] - price[m] + T[i - 1][m]);
                }
                T[i][j] = Math.max(T[i][j - 1], maxPreviousSFar);
            }
        }

        return T[k][price.length - 1];
    }

    public int maxProfit4FastSolution(int[] price, int k) {
        if (price == null || price.length == 0) return 0;

        int T[][] = new int[k + 1][price.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -price[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], price[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - price[j]);
            }
        }

        return T[k][price.length - 1];
    }


    /**
     * Your are given an array of integers prices,
     * for which the i-th element is the price of a given stock on day i;
     * and a non-negative integer fee representing a transaction fee.
     * <p>
     * You may complete as many transactions as you like,
     * but you need to pay the transaction fee for each transaction.
     * You may not buy more than 1 share of a stock at a time
     * (ie. you must sell the stock share before you buy again.)
     * <p>
     * Return the maximum profit you can make.
     * <p>
     * Example 1:
     * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * Output: 8
     * Explanation: The maximum profit can be achieved by:
     * Buying at prices[0] = 1
     * Selling at prices[3] = 8
     * Buying at prices[4] = 4
     * Selling at prices[5] = 9
     * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * Note:
     * <p>
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitWithTransactionFee(int[] prices, int fee) {

        if (prices == null || prices.length == 0) return 0;

        int cash = 0; // sell if you see profit
        int hold = -prices[0]; // buy if you enough cash
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }


    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * <p>
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * Example:
     * <p>
     * Input: [1,2,3,0,2]
     * Output: 3
     * Explanation: transactions = [buy, sell, cooldown, buy, sell]
     *
     * @param prices
     * @return
     */
    public int maxProfitWithCooldown(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // let b2, b1, b0 represent max profit after buying in i-2, i-1, ith day
        // let s2, s1, s0 represent max profit after selling in i-2, i-1, ith day
        int b1 = -prices[0];
        int s1 = 0;
        int s2 = 0;

        for (int i = 1; i < prices.length; i++) {
            int b0 = Math.max(b1, s2 - prices[i]);
            int s0 = Math.max(s1, b1 + prices[i]);

            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s1;
    }

    @Test
    public void test_maxProfit1() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(5, solution.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(0, solution.maxProfit1(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test_maxProfit2() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(7, solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, solution.maxProfit2(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, solution.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test_maxProfit2UsingDp() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(7, solution.maxProfit2UsingDp(new int[]{7, 1, 5, 3, 6, 4}));
        Assert.assertEquals(4, solution.maxProfit2UsingDp(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, solution.maxProfit2UsingDp(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test_maxProfit3() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(6, solution.maxProfit3(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        Assert.assertEquals(4, solution.maxProfit3(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(0, solution.maxProfit3(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    public void test_maxProfit4SlowSolution() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(2, solution.maxProfit4SlowSolution(new int[]{2, 4, 1}, 2));
        Assert.assertEquals(7, solution.maxProfit4SlowSolution(new int[]{3, 2, 6, 5, 0, 3}, 2));
    }

    @Test
    public void test_maxProfit4FastSolution() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(2, solution.maxProfit4FastSolution(new int[]{2, 4, 1}, 2));
        Assert.assertEquals(7, solution.maxProfit4FastSolution(new int[]{3, 2, 6, 5, 0, 3}, 2));
    }

    @Test
    public void test_maxProfitWithTransactionFee() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(8, solution.maxProfitWithTransactionFee(new int[]{1, 3, 2, 8, 4, 9}, 2));
        Assert.assertEquals(6, solution.maxProfitWithTransactionFee(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    @Test
    public void test_maxProfitWithCooldown() {
        BuySellStock solution = new BuySellStock();

        Assert.assertEquals(3, solution.maxProfitWithCooldown(new int[]{1, 2, 3, 0, 2}));
    }
}
