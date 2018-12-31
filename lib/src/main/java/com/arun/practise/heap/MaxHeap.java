package com.arun.practise.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxHeap {

    static final int DEFAULT_SIZE = 10;
    int[] heap;
    private int size = DEFAULT_SIZE;

    public MaxHeap() {
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
        this.size = heap.length;
    }


    void buildMaxHeap() {
        for (int i = size / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    void heapify(int index) {
        int left = getLeftIndex(index);
        int right = getRightIndex(index);

        int biggest = left < size && heap[left] > heap[index] ? left : index;

        biggest = right < size && heap[right] > heap[biggest] ? right : biggest;

        if (biggest != index) {
            swap(biggest, index);
            heapify(biggest);
        }

    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    int getLeftIndex(int i) {
        return 2 * i;
    }

    int getRightIndex(int i) {
        return (2 * i) + 1;
    }

    int getParent(int i) {
        return (i - 1) / 2;
    }


    void doHeapSort() {
        for (int i = 0; i < heap.length - 1; i++) {
            buildMaxHeap();

            swap(0, size - 1);
            size--;
        }
    }

    @Test
    public void test_buildMaxHeap() {
        int[] a = new int[]{3, 16, 8, 1, 9, 14, 7, 10, 2, 4};
        MaxHeap solution = new MaxHeap();
        solution.setHeap(a);
        solution.buildMaxHeap();
        System.out.println(Arrays.toString(solution.heap));
        Assert.assertArrayEquals(new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1}, solution.heap);
    }

    @Test
    public void test_doHeapSort() {
        int[] a = new int[]{3, 16, 8, 1, 9, 14, 7, 10, 2, 4};
        MaxHeap solution = new MaxHeap();
        solution.setHeap(a);
        solution.doHeapSort();
        System.out.println(Arrays.toString(solution.heap));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16}, solution.heap);
    }


}
