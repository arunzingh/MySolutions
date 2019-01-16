package com.arun.practise.arrays;


import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }

        int index = digits.length - 1;
        int carry = 1;

        int[] result = new int[digits.length];

        while (index >= 0) {
            int sum = digits[index] + carry;
            int rem = sum % 10;
            int q = sum / 10;

            result[index] = q > 0 ? rem : sum;
            carry = q;

            index--;
        }

        if(carry > 0) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(result, 0, temp, 0, result.length);
            temp[0] = carry;
            result = temp;
        }

        return result;
    }

    public int[] plusOne1(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    @Test
    public void test_plusOne() {
        PlusOne solution = new PlusOne();
        Assert.assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne1(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{4, 3, 2, 2}, solution.plusOne1(new int[]{4, 3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1}, solution.plusOne1(new int[]{0}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, solution.plusOne1(new int[]{9, 9}));
    }
}
