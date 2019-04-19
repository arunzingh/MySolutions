package com.arun.practise.trees;

import com.arun.practise.linkedlist.LLUtils;

import org.junit.Test;

public class BstToSortedDoublyLinkedList {

    public TreeNode treeToDoublyList(TreeNode curr) {
        if (curr == null) {
            return curr;
        }

        TreeNode left = treeToDoublyList(curr.left);
        TreeNode right = treeToDoublyList(curr.right);

        curr.left = curr;
        curr.right = curr;

        TreeNode head = join(left, curr);
        head = join(head.left, right);

        return head.left;
    }

    private TreeNode join(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null) {
            return nodeB;
        }

        if (nodeB == null) {
            return nodeA;
        }

        TreeNode first = nodeA.right;
        TreeNode last = nodeB.left;

        nodeA.right = nodeB;
        nodeB.left = nodeA;

        nodeA.left = last;
        nodeB.right = first;

        return first;
    }

    @Test
    public void test_treeToDoublyList() {
        BstToSortedDoublyLinkedList solution = new BstToSortedDoublyLinkedList();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);

        TreeNode result = solution.treeToDoublyList(root);
        LLUtils.printList(result);
    }
}
