package com.arun.practise.linkedlist;

import com.arun.practise.trees.TreeNode;

import org.junit.Assert;
import org.junit.Test;

public class LLUtils {

    public static int getLength(ListNode head) {
        int count = 0;
        if (head == null) {
            return count;
        }

        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printList(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);
            if (curr.right != null) {
                System.out.print(" -> ");
            }
            curr = curr.right;
        }
        System.out.println();
    }

    public static void printListDown(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);
            if (curr.down != null) {
                System.out.print(" -> ");
            }
            curr = curr.down;
        }
        System.out.println();
    }

    public static boolean isSame(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return true;
        }

        if (head1 == null || head2 == null) {
            return false;
        }

        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }

    @Test
    public void test_isSame() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);
        ListNode m4 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        Assert.assertTrue(LLUtils.isSame(n1, m1));
    }

    @Test
    public void test_isSame_t3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);

        m1.next = m2;
        m2.next = m3;

        Assert.assertFalse(LLUtils.isSame(n1, m1));
    }

    @Test
    public void test_isSame_t4() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        ListNode m3 = new ListNode(3);

        m1.next = m2;
        m2.next = m3;

        Assert.assertFalse(LLUtils.isSame(m1, n1));
    }

    @Test
    public void test_isSame_t2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        Assert.assertFalse(LLUtils.isSame(n1, null));
        Assert.assertFalse(LLUtils.isSame(null, n1));
        Assert.assertTrue(LLUtils.isSame(null, null));
    }




    @Test
    public void test_getLength() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Assert.assertEquals(5, getLength(n1));
        printList(n1);

        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Assert.assertEquals(6, getLength(n1));
        printList(n1);
    }
}
