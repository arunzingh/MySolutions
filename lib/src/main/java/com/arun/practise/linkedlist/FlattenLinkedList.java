package com.arun.practise.linkedlist;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 */
public class FlattenLinkedList {

    ListNode flatten(ListNode head) {
        ListNode curr = head;
        ListNode result = null;

        while (curr.next != null) {
            ListNode next = curr.next.next;
            result = merge(curr, curr.next);

            result.next = next;
            curr = result;
        }

        return result;
    }


    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode result;

        if (head1.val < head2.val) {
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

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(7);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(30);

        a1.down = a2;
        a2.down = a3;
        a3.down = a4;

        ListNode b1 = new ListNode(10);
        ListNode b2 = new ListNode(20);

        b1.down = b2;

        ListNode c1 = new ListNode(19);
        ListNode c2 = new ListNode(22);
        ListNode c3 = new ListNode(50);

        c1.down = c2;
        c2.down = c3;

        ListNode d1 = new ListNode(28);
        ListNode d2 = new ListNode(35);
        ListNode d3 = new ListNode(40);
        ListNode d4 = new ListNode(45);

        d1.down = d2;
        d2.down = d3;
        d3.down = d4;

        a1.next = b1;
        b1.next = c1;
        c1.next = d1;

        ListNode result = solution.flatten(a1);
        LLUtils.printListDown(result);
    }


}
