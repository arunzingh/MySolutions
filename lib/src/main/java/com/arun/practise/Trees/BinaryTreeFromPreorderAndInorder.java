package com.arun.practise.Trees;

import org.junit.Test;

public class BinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeUtil(int[] preorder, int preIndex, int[] inorder, int inStart, int inEnd) {

        if (preIndex == preorder.length) {
            return null;
        }

        if (inStart > inEnd) {
            return null;
        }

        int value = preorder[preIndex];
        TreeNode n = new TreeNode(value);

        int index = find(inorder, value, inStart, inEnd);
        n.left = buildTreeUtil(preorder, preIndex + 1, inorder, inStart, index - 1);
        n.right = buildTreeUtil(preorder, preIndex + index - inStart + 1, inorder, index + 1, inEnd);

        return n;
    }

    private int find(int[] arr, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test_buildTree() {
        BinaryTreeFromPreorderAndInorder solution = new BinaryTreeFromPreorderAndInorder();
        // preorder = [3,9,20,15,7]
        // inorder = [9,3,15,20,7]

        int[] pre = new int[] {3,9,20,15,7};
        int[] in = new int[] {9,3,15,20,7};

        TreeNode result = solution.buildTree(pre, in);
        BTreePrinter.printNode(result);
    }

}



