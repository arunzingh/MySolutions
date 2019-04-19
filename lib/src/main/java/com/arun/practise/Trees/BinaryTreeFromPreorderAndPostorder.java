package com.arun.practise.trees;

import org.junit.Test;

public class BinaryTreeFromPreorderAndPostorder {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }


    TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }


        TreeNode n = new TreeNode(pre[preStart]);

        int subTreePostEnd = search(post, postStart, postEnd, pre[preStart + 1]);
        int subTreePreEnd = preStart + (subTreePostEnd - postStart) + 1;

        n.left = buildTree(pre, preStart + 1, subTreePreEnd, post, postStart, subTreePostEnd);
        n.right = buildTree(pre, subTreePreEnd + 1, preEnd, post, subTreePostEnd + 1, postEnd - 1);

        return n;
    }

    private int search(int[] post, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (post[i] == key) {
                return i;
            }
        }

        throw new IllegalArgumentException(String.format("key not found in post order, key=%s, start=%s, end=%s", key, start, end));
    }

    @Test
    public void test_constructFromPrePost() {
        BinaryTreeFromPreorderAndPostorder solution = new BinaryTreeFromPreorderAndPostorder();
        TreeNode result = solution.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        BTreePrinter.printNode(result);

    }
}
