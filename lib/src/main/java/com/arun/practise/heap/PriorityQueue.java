package com.arun.practise.heap;

import org.junit.Test;

import java.util.NoSuchElementException;

public class PriorityQueue {

    int size = 0;
    int[] heap = new int[size];

    public boolean add(int element) {
        if (size == heap.length) {
            return false;
        }

        heap[size] = element;
        size++;
        return true;
    }

    public int getMaximum() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap[0];
    }

    public int extractMax() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        int result = heap[0];
        heap[0] = heap[size];
        size--;
        heapify(0);
        return result;
    }

    public void heapify(int index) {

        int left = getLeft(index);
        int right = getRight(index);

        // compare current not and its left child
        int largest = left < size && heap[left] > heap[index] ? left : index;
        // compare the largest of above with right child
        largest = right < size && heap[right] > heap[largest] ? right : largest;

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private int getRight(int index) {
        return (2 * index) + 1;
    }

    private int getLeft(int index) {
        return (2 * index);
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean increaseKey(int index, int newValue) {
        if (newValue < heap[index]) {
            return false;
        }

        heap[index] = newValue;

        while (getParent(index) >= 0 && heap[getParent(index)] < heap[index]) {
            swap(getParent(index), index);
            index = getParent(index);
        }

        return true;
    }

    @Test
    public void test_add() {
        PriorityQueue solution = new PriorityQueue();
//        Assert.assertTrue(solution.add());
    }
}
