package com.arun.practise.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        Iterator<Interval> it = intervals.iterator();
        List<Interval> result = new ArrayList<>(intervals.size());
        Interval curr = it.next();

        while (it.hasNext()) {
            Interval next = it.next();

            if (curr.end >= next.start) {
                curr.end = Math.max(curr.end, next.end);
            } else {
                result.add(new Interval(curr.start, curr.end));
                curr = next;
            }

        }
        result.add(new Interval(curr.start, curr.end));
        return result;
    }

    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {

            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    @Test
    public void test_merge() {
        MergeIntervals solution = new MergeIntervals();
        // [[1,3],[2,6],[8,10],[15,18]]
        List<Interval> input = new ArrayList<>(4);
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));

        List<Interval> expected = new ArrayList<>(3);
        expected.add(new Interval(1, 6));
        expected.add(new Interval(8, 10));
        expected.add(new Interval(15, 18));

        Assert.assertEquals(expected, solution.merge(input));
    }

    @Test
    public void test_merge_t2() {
        MergeIntervals solution = new MergeIntervals();
        List<Interval> input = new ArrayList<>(2);
        input.add(new Interval(1, 4));
        input.add(new Interval(4, 5));

        List<Interval> expected = new ArrayList<>(1);
        expected.add(new Interval(1, 5));

        Assert.assertEquals(expected, solution.merge(input));
    }


    @Test
    public void test_merge_t3() {
        MergeIntervals solution = new MergeIntervals();
        List<Interval> input = new ArrayList<>(2);
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 3));

        List<Interval> expected = new ArrayList<>(1);
        expected.add(new Interval(1, 4));

        Assert.assertEquals(expected, solution.merge(input));
    }
}

