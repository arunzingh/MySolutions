package com.arun.practise.linkedlist;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 */
public class FlattenLinkedList {

    Node flatten(Node head) {
        Node curr = head;
        Node result = null;

        while (curr.next != null) {
            Node next = curr.next.next;
            result = merge(curr, curr.next);

            result.next = next;
            curr = result;
        }

        return result;
    }


    Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        Node result;

        if (head1.data < head2.data) {
            result = head1;
            result.down = merge(head1.down, head2);
        } else {
            result = head2;
            result.down = merge(head1, head2.down);
        }

        return result;
    }


    @Test
    public void test_flatten() {
        FlattenLinkedList solution = new FlattenLinkedList();

        Node a1 = new Node(5);
        Node a2 = new Node(7);
        Node a3 = new Node(8);
        Node a4 = new Node(30);

        a1.down = a2;
        a2.down = a3;
        a3.down = a4;

        Node b1 = new Node(10);
        Node b2 = new Node(20);

        b1.down = b2;

        Node c1 = new Node(19);
        Node c2 = new Node(22);
        Node c3 = new Node(50);

        c1.down = c2;
        c2.down = c3;

        Node d1 = new Node(28);
        Node d2 = new Node(35);
        Node d3 = new Node(40);
        Node d4 = new Node(45);

        d1.down = d2;
        d2.down = d3;
        d3.down = d4;

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        Node result = solution.flatten(a1);
        LLUtils.printListDown(result);
    }


}
