package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class QueueUsingList {

    Node head;
    Node tail;

    boolean add(int element) {
        Node newNode = new Node(element);

        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;

        if (head == null) {
            head = newNode;
        }

        return true;
    }

    int remove() {
        if (head == null)
            throw new NoSuchElementException("queue is empty");

        int element = head.data;
        head = head.next;

        if (head == null)
            tail = null;

        return element;
    }

    int peek() {
        if (head == null)
            throw new NoSuchElementException("queue is empty");

        return head.data;
    }


    boolean isEmpty() {
        return head == null;
    }


    @Test(expected = NoSuchElementException.class)
    public void test_peekWhenEmpty() {
        QueueUsingList solution = new QueueUsingList();
        solution.peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_removeWhenEmpty() {
        QueueUsingList solution = new QueueUsingList();
        solution.peek();
    }

    @Test
    public void test_queue() {
        QueueUsingList solution = new QueueUsingList();
        Assert.assertTrue(solution.add(1));
        Assert.assertEquals(1, solution.peek());
        Assert.assertTrue(solution.add(2));
        Assert.assertEquals(1, solution.peek());
        Assert.assertTrue(solution.add(3));
        Assert.assertEquals(1, solution.peek());
        Assert.assertTrue(solution.add(4));
        Assert.assertEquals(1, solution.peek());
        Assert.assertTrue(solution.add(5));
        Assert.assertEquals(1, solution.peek());

        Assert.assertTrue(solution.add(6));
        Assert.assertEquals(1, solution.peek());

        Assert.assertEquals(1, solution.remove());
        Assert.assertEquals(2, solution.peek());

        Assert.assertTrue(solution.add(7));
        Assert.assertEquals(2, solution.peek());

        Assert.assertEquals(2, solution.remove());
        Assert.assertEquals(3, solution.remove());
        Assert.assertEquals(4, solution.remove());
        Assert.assertEquals(5, solution.remove());

        Assert.assertTrue(solution.add(8));
        Assert.assertEquals(6, solution.peek());

        Assert.assertEquals(6, solution.remove());
        Assert.assertEquals(7, solution.remove());
        Assert.assertFalse(solution.isEmpty());
        Assert.assertEquals(8, solution.remove());
        Assert.assertTrue(solution.isEmpty());

    }
}
