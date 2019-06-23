package com.arun.practise.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Kmp {
    public int search(String text, String pattern) {


        int[] table = computeJump(pattern);

        int j = 0;
        for (int i = 0; i < text.length(); i++) {

            while (j > 0 && text.charAt(i) != text.charAt(j)) {
                j = table[j - 1];
            }

            if (text.charAt(i) == text.charAt(j)) {
                j++;
            }

            if (j == pattern.length() - 1) {
                // match found;
                return i;
            }
        }

        return -1;
    }

    public int[] computeJump(String pattern) {

        int[] table = new int[pattern.length()];
        int j = 0;
        table[0] = j;

        for (int i = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = table[j - 1];
            }

            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            table[i] = j;
        }
        System.out.println(Arrays.toString(table));
        return table;
    }

    @Test
    public void test_computeJump() {
        Kmp solution = new Kmp();
        Assert.assertArrayEquals(new int[] {0, 0, 1, 2, 3, 0, 1}, solution.computeJump("ababaca"));
        Assert.assertArrayEquals(new int[] {0, 0, 0, 1, 2, 0}, solution.computeJump("abcaby"));
        Assert.assertArrayEquals(new int[] {0, 0, 1, 2, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 4}, solution.computeJump("acacabacacabacacac"));
    }

    @Test
    public void test_temp() {
        String input = "a";

        int l = 0;
        int r = 0;

        while (l <= r) {
            System.out.println("l=" + l + " r=" + r + " sub=" + input.substring(l, r));
            if (r < input.length()) r++;
            else l++;
        }

        for (int i = 0; i < input.length(); i++) {

        }
    }
}
