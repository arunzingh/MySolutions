package com.arun.practise.trees;

public class TreeUtils {

    static int getHeight(TreeNode curr) {
        if (curr == null)
            return 0;

        return 1 + Math.max(getHeight(curr.left), getHeight(curr.right));
    }
}
