package com.arun.practise.substring;

import org.junit.Test;

import java.util.Scanner;

/**
 * Chef was reading some quotes by great people. Now, he is interested in classifying all the fancy quotes he knows.
 * He thinks that all fancy quotes which contain the word "not" are Real Fancy; quotes that do not contain it are regularly fancy.
 *
 * You are given some quotes. For each quote, you need to tell Chef if it is Real Fancy or just regularly fancy.
 *
 * Input
 * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
 * The first and only line of each test case contains a single string S denoting a quote.
 * Output
 * For each test case, print a single line containing the string "Real Fancy" or "regularly fancy" (without quotes).
 *
 * Constraints
 * 1≤T≤50
 * 1≤|S|≤100
 * each character of S is either a lowercase English letter or a space
 * Subtasks
 * Subtask #1 (100 points): original constraints
 *
 * Example Input
 * 2
 * i do not have any fancy quotes
 * when nothing goes right go left
 *
 * Example Output
 * Real Fancy
 * regularly fancy
 *
 */
public class FancyQuotes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCases = sc.nextInt();
        sc.nextLine();
//        System.out.println("numTestCases=" + numTestCases);
        String pattern = "not";
        int[] badmatch = buildBarCharMatchTable(pattern);
        for (int i = 0; i < numTestCases; i++) {
            String text = sc.nextLine();
//            System.out.println("text=" + text);
            boolean result = doBoyerMooreSearch(text.toCharArray(), pattern.toCharArray(), badmatch);
            System.out.println(result ? "Real Fancy" : "regularly fancy");
        }
    }

    public static int[] buildBarCharMatchTable(String pattern) {
        int[] badmatch = new int[256];

        for (int i = 0; i < badmatch.length; i++) {
            badmatch[i] = -1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            badmatch[pattern.charAt(i)] = i;
        }

        return badmatch;
    }

    public static boolean doBoyerMooreSearch(char[] text, char[] pattern, int[] badchar) {
        int shift = 0;
        int m = pattern.length;
        int n = text.length;

        while (shift <= n-m) {
            int j = m-1;

            while (j >= 0 && text[shift+j] == pattern[j]) {
                j--;
            }

            if (j < 0) {
                // found
                if(shift == 0 && shift + m < n && text[shift + m] == ' ') {
                    return true;
                } else if(shift + m == n && shift-1 > 0 && text[shift-1] == ' ') {
                    return true;
                } else if (shift + m < n && text[shift + m] == ' ' && shift-1 > 0 && text[shift-1] == ' ') {
                    return true;
                } else if (new String(text).trim().equals("not")) {
                    return true;
                }

                shift += shift + m < n ? m - badchar[text[shift + m]] : 1;
            } else {
                // no match, need to shift
                shift += Math.max(1, j - badchar[text[shift + j]]);
            }
        }

        return false;
    }

//    @Test
//    public void test_fancy() {
//        FancyQuotes solution = new FancyQuotes();
//
//        String text = "aad abc d";
//        String pattern = " abc ";
//
//        int[] badmatch = solution.buildBarCharMatchTable(pattern);
//        solution.doBoyerMooreSearch(text.toCharArray(), pattern.toCharArray(), badmatch);
//
//        text = " abc aacd";
//
//        solution.doBoyerMooreSearch(text.toCharArray(), pattern.toCharArray(), badmatch);
//
//        text = "aada abc ";
//
//        solution.doBoyerMooreSearch(text.toCharArray(), pattern.toCharArray(), badmatch);
//
//        text = "aadaabe";
//
//        solution.doBoyerMooreSearch(text.toCharArray(), pattern.toCharArray(), badmatch);
//    }
}
