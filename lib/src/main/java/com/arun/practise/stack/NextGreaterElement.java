package com.arun.practise.stack;

import org.junit.Test;

import java.util.Stack;

public class NextGreaterElement {

    void printNextGreaterElement(int[] input) {

        Stack<Integer> stack = new Stack();

        for (int num : input) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int popped = stack.pop();
                System.out.print(num + " ");
            }
            stack.push(num);
        }

        while(!stack.isEmpty()) {
            stack.pop();
            System.out.print("-1 ");
        }

    }

    @Test
    public void test_printNextGreaterElement() {
        NextGreaterElement solution = new NextGreaterElement();
        solution.printNextGreaterElement(new int[] {1, 3, 2, 4});
    }
}
