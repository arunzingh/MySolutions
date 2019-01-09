package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 */
public class RemoveNthNodeFromEnd {

    Node removeNthNode(Node head, int n) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        int count = 0;

        while (count < n && fast != null) {
            fast = fast.next;

            if (fast == null){
                // cases where list ran over before n or head is exactly at nth position from end.
                return (count + 1) == n ? head.next : head;
            }

            count++;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    @Test
    public void test_removeNthNode() {
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node result = solution.removeNthNode(n1, 2);
        LLUtils.printList(result);


        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        result = solution.removeNthNode(n1, 2);
        LLUtils.printList(result);

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        result = solution.removeNthNode(n1, 3);
        LLUtils.printList(result);

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        result = solution.removeNthNode(n1, 4);
        LLUtils.printList(result);

        n1 = new Node(1);

        result = solution.removeNthNode(n1, 1);
        Assert.assertNull(result);
        LLUtils.printList(result);


    }


}
