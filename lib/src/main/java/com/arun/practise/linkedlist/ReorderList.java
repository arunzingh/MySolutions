package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;


        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;

        ListNode first = head;
        ListNode second = reverse(slow);

        while (first != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            // handle situation where first list ended
            // and second list has more than one elements
            // first 1 -> null
            // second 3 -> 2
            // no need to set second to point to t1 as we want to continue with remaining in second
            if (t1 == null) {
                break;
            }

            second.next = t1;

            first = t1;
            second = t2;
        }

        LLUtils.printList(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    @Test
    public void test_reorderList() {
        ReorderList solution = new ReorderList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        solution.reorderList(n1);

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(4);
        ListNode e3 = new ListNode(2);
        ListNode e4 = new ListNode(3);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;

        Assert.assertTrue(LLUtils.isSame(e1, n1));

    }

    @Test
    public void test_reorderList_t2() {
        ReorderList solution = new ReorderList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        solution.reorderList(n1);

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(3);
        ListNode e3 = new ListNode(2);

        e1.next = e2;
        e2.next = e3;

        Assert.assertTrue(LLUtils.isSame(e1, n1));

    }

    @Test
    public void test_reorderList_t4() {
        ReorderList solution = new ReorderList();

        ListNode n1 = new ListNode(1);
        solution.reorderList(n1);
        ListNode e1 = new ListNode(1);

        Assert.assertTrue(LLUtils.isSame(e1, n1));

    }

    @Test
    public void test_reorderList_t5() {
        ReorderList solution = new ReorderList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        solution.reorderList(n1);

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        e1.next = e2;

        Assert.assertTrue(LLUtils.isSame(e1, n1));

    }

    @Test
    public void test_reorderList_t3() {
        ReorderList solution = new ReorderList();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        solution.reorderList(n1);

        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(5);
        ListNode e3 = new ListNode(2);
        ListNode e4 = new ListNode(4);
        ListNode e5 = new ListNode(3);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;

        Assert.assertTrue(LLUtils.isSame(e1, n1));

    }

}
