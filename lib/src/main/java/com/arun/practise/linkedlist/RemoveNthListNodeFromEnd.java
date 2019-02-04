package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 */
public class RemoveNthListNodeFromEnd {

    ListNode removeNthNode(ListNode head, int n) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

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
        RemoveNthListNodeFromEnd solution = new RemoveNthListNodeFromEnd();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode result = solution.removeNthNode(n1, 2);
        LLUtils.printList(result);


        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        result = solution.removeNthNode(n1, 2);
        LLUtils.printList(result);

        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        result = solution.removeNthNode(n1, 3);
        LLUtils.printList(result);

        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        result = solution.removeNthNode(n1, 4);
        LLUtils.printList(result);

        n1 = new ListNode(1);

        result = solution.removeNthNode(n1, 1);
        Assert.assertNull(result);
        LLUtils.printList(result);


    }


}
