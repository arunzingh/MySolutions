package com.arun.practise.trees;

import org.junit.Test;

public class BinaryTreeFromPreorderAndPostorder {
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preIndex = 0;
        return constructFromPrePostUtil(pre, post, 0, post.length - 1);
    }

    private TreeNode constructFromPrePostUtil(int[] pre, int[] post, int postStart, int postEnd) {
        TreeNode node = null;

        if (preIndex < pre.length && postStart <= postEnd && postStart >= 0) {
            int value = pre[preIndex];
            node = new TreeNode(value);
            int rootIndex = search(post, value, postStart, postEnd);
            preIndex++;
            if (preIndex < pre.length) {
                int index2 = search(post, pre[preIndex], postStart, rootIndex - 1);

                node.left = constructFromPrePostUtil(pre, post, postStart, index2);
                node.right = constructFromPrePostUtil(pre, post, index2, rootIndex - 1);
            }

        }

        return node;
    }

    private int search(int[] array, int key, int start, int end) {

        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test_constructFromPrePost() {
        BinaryTreeFromPreorderAndPostorder solution = new BinaryTreeFromPreorderAndPostorder();
        TreeNode result = solution.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        BTreePrinter.printNode(result);

    }
}
