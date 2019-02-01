package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                maxLength = Math.max(maxLength, i - start);
                int freshStart = map.get(c) + 1;
                start = Math.max(start, freshStart);
                map.put(c, i);
                i++;
            } else {
                map.put(c, i);
                i++;
            }
        }
        maxLength = Math.max(maxLength, i - start);
        return maxLength;

    }

    @Test
    public void test_lengthOfLongestSubstring() {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        Assert.assertEquals(2, solution.lengthOfLongestSubstring("abba"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring(" "));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
    }
}
