package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public double findMedianByKthElement(int[] nums1, int[] nums2) {
        double result = 0.0;

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        if (total % 2 == 1) {
            // odd, k = total / 2 th element
            return findKthElement(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            // even, k = avg of (total / 2) - 1 and total / 2 elements
            return (findKthElement(nums1, 0, nums2, 0, total / 2) + findKthElement(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }
    }


    double findKthElement(int[] arr1, int start1, int[] arr2, int start2, int k) {
        // If arr1 is ranover, take arr2's kth element
        if (start1 >= arr1.length) {
            return arr2[start2 + k - 1];
        }

        // If arr2 ranover, take arr1's kth element
        if (start2 >= arr2.length) {
            return arr1[start1 + k - 1];
        }

        // If k = 1, take min of both
        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        int index1 = start1 + k / 2 - 1;
        int index2 = start2 + k / 2 - 1;

        // MAX_VALUE is important so that elements in arr1 is counted for computing Kth element
        // If we use MIN_VALUE here, elements in arr1 are skipped hence kth element would be incorrect
        int key1 = index1 < arr1.length ? arr1[index1] : Integer.MAX_VALUE;
        int key2 = index2 < arr2.length ? arr2[index2] : Integer.MAX_VALUE;

        if (key1 < key2) {
            return findKthElement(arr1, start1 + k / 2, arr2, start2, k - k / 2);
        } else {
            return findKthElement(arr1, start1, arr2, start2 + k / 2, k - k / 2);
        }
    }

    public double findMedianByPartition(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianByPartition(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = nums1.length;

        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = (x  + y + 1) / 2 - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];


            if (maxLeftX <= minRightY
                    && maxLeftY <= minRightX) {
                // right partition
                // If odd get max of left side
                // If event get average of max of left side and min of right side
                if ((x + y) % 2 == 1) {
                    // odd
                    return (double) Math.max(maxLeftX, maxLeftY);
                } else {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0 ;
                }

            } else if (maxLeftX > minRightY)
                // too much on right side of X
                // move towards left
                end = partitionX - 1;
            else {
                // else move towards right
                start = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    @Test
    public void test_findMedianByKthElement() {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
//        Assert.assertEquals(2.0, solution.findMedianByKthElement(new int[] {1, 3}, new int[] {2}), Double.MIN_NORMAL);
//        Assert.assertEquals(2.5, solution.findMedianByKthElement(new int[] {1, 2}, new int[] {3, 4}), Double.MIN_NORMAL);
//        Assert.assertEquals(3.5, solution.findMedianByKthElement(new int[] {1}, new int[] {2, 3, 4, 5, 6}), Double.MIN_NORMAL);

        Assert.assertEquals(2.0, solution.findMedianByPartition(new int[] {1, 3}, new int[] {2}), Double.MIN_NORMAL);
        Assert.assertEquals(2.5, solution.findMedianByPartition(new int[] {1, 2}, new int[] {3, 4}), Double.MIN_NORMAL);
        Assert.assertEquals(3.5, solution.findMedianByPartition(new int[] {1}, new int[] {2, 3, 4, 5, 6}), Double.MIN_NORMAL);
    }
}
