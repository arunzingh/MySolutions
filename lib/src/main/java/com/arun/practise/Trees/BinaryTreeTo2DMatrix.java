package com.arun.practise.trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeTo2DMatrix {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        int level = getMaxLevel(root);
        int nodes = (int) (Math.pow(2, level) - 1);

        List<String> row = new ArrayList<>(nodes);
        for (int j = 0; j < nodes; j++) {
            row.add(new String(""));
        }

        for (int i = 0; i < level; i++) {
            result.add(new ArrayList<String>(row));
        }

        fillMatrix(root, 0, result, 0, nodes - 1);

        return result;
    }

    private void fillMatrix(TreeNode curr, int level, List<List<String>> result, int start, int end) {

        if (start > end || curr == null) {
            return;
        }

        if (start == end) {
            result.get(level).set(start, String.valueOf(curr.val));
            return;
        }

        int mid = (start  + end) / 2;
        result.get(level).set(mid, String.valueOf(curr.val));
        fillMatrix(curr.left, level + 1, result, start, mid - 1);
        fillMatrix(curr.right, level + 1, result, mid + 1, end);

    }

    private int getMaxLevel(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        return 1 + Math.max(getMaxLevel(curr.left), getMaxLevel(curr.right));
    }

    @Test
    public void test_printTree() {
        BinaryTreeTo2DMatrix solution = new BinaryTreeTo2DMatrix();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("", "1", ""));
        expected.add(Arrays.asList("2", "", ""));

        Assert.assertEquals(expected, solution.printTree(root));
    }

    @Test
    public void test_printTree_t2() {
        BinaryTreeTo2DMatrix solution = new BinaryTreeTo2DMatrix();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("", "", "", "1", "", "", ""));
        expected.add(Arrays.asList("", "2", "", "", "", "3", ""));
        expected.add(Arrays.asList("", "", "4", "", "", "", ""));

        Assert.assertEquals(expected, solution.printTree(root));
    }


    @Test
    public void test_printTree_t3() {
        BinaryTreeTo2DMatrix solution = new BinaryTreeTo2DMatrix();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""));
        expected.add(Arrays.asList("",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""));
        expected.add(Arrays.asList("",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""));
        expected.add(Arrays.asList("4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""));

        Assert.assertEquals(expected, solution.printTree(root));
    }

}
