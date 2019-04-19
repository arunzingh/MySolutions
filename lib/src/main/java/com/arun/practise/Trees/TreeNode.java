package com.arun.practise.trees;

import java.util.List;

public class TreeNode<T> {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public List<TreeNode<T>> children;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val
                + " left=" + (left == null ? "empty" : left.val)
                + " right=" + (right == null ? "empty" : right.val);
    }
}