package com.arun.practise.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LLUtils {

    static int getLength(Node head) {
        int count = 0;
        if (head == null) {
            return count;
        }

        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    static void printList(Node head) {
        if (head == null) {
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }


    static void printListDown(Node head) {
        if (head == null) {
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);
            if (curr.down != null) {
                System.out.print(" -> ");
            }
            curr = curr.down;
        }
        System.out.println();
    }



    @Test
    public void test_getLength() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Assert.assertEquals(5, getLength(n1));
        printList(n1);

        n1 = new Node(1);
        n2 = new Node(2);
        n3 = new Node(3);
        n4 = new Node(4);
        n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Assert.assertEquals(6, getLength(n1));
        printList(n1);
    }
}
