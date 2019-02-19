package com.arun.practise.trees;

import org.junit.Test;

import java.util.Stack;

/**
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class FlattenBTToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        flattenUtil(root, stack);
    }

    private TreeNode flattenUtil(TreeNode curr, Stack<TreeNode> stack) {

        if (curr == null && stack.isEmpty()) {
            return null;
        }

        if (curr == null) {
            curr = stack.pop();
        }

        if (curr.right != null) {
            stack.push(curr.right);
        }

        curr.right = flattenUtil(curr.left, stack);
        curr.left = null;

        return curr;
    }

    @Test
    public void test_flatten() {
        FlattenBTToLinkedList solution = new FlattenBTToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
        BTreePrinter.printNode(root);
    }
}
