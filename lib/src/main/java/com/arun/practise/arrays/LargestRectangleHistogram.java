package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LargestRectangleHistogram {

    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;

        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int index = 0;

        while (!stack.isEmpty() || index < heights.length) {

            if (stack.isEmpty() || (index < heights.length
                    && heights[stack.peek()] < heights[index])) {
                stack.push(index);
                index++;
                continue;
            }


            int j = stack.pop();
            int area = 0;
            if (stack.isEmpty()) {
                area = heights[j] * index;
            } else {
                area = heights[j] * (index - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    @Test
    public void test_largestRectangleArea() {
        LargestRectangleHistogram solution = new LargestRectangleHistogram();
        Assert.assertEquals(3, solution.largestRectangleArea(new int[]{2, 1, 2}));
        Assert.assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
