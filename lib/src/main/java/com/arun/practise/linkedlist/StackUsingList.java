package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class StackUsingList {

    ListNode top;

    boolean push(int element) {

        ListNode newListNode = new ListNode(element);
        newListNode.next = top;
        top = newListNode;
        return true;
    }

    int peek() {
        if (top == null)
            throw new NoSuchElementException("stack is empty");

        return top.val;
    }

    int pop() {
        if (top == null)
            throw new NoSuchElementException("stack is empty");

        int element = top.val;
        top = top.next;
        return element;
    }

    boolean isEmpty() {
        return top == null;
    }

    @Test(expected = NoSuchElementException.class)
    public void test_peekWhileEmpty() {
        StackUsingList solution = new StackUsingList();
        solution.peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void test_popWhileEmpty() {
        StackUsingList solution = new StackUsingList();
        solution.pop();
    }

    @Test
    public void test_stack() {
        StackUsingList solution = new StackUsingList();
        Assert.assertTrue(solution.push(1));
        Assert.assertEquals(1, solution.peek());
        Assert.assertTrue(solution.push(2));
        Assert.assertEquals(2, solution.peek());
        Assert.assertTrue(solution.push(3));
        Assert.assertEquals(3, solution.peek());
        Assert.assertTrue(solution.push(4));
        Assert.assertEquals(4, solution.peek());
        Assert.assertTrue(solution.push(5));
        Assert.assertEquals(5, solution.peek());

        Assert.assertEquals(5, solution.pop());
        Assert.assertEquals(4, solution.peek());
        Assert.assertEquals(4, solution.pop());
        Assert.assertEquals(3, solution.peek());
        Assert.assertEquals(3, solution.pop());
        Assert.assertEquals(2, solution.peek());
        Assert.assertEquals(2, solution.pop());
        Assert.assertEquals(1, solution.peek());
        Assert.assertEquals(1, solution.pop());
    }
}
