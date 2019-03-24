package com.arun.practise.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UniqueBstGeneration {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateTreeUtil(1, n);
    }

    private List<TreeNode> generateTreeUtil(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTreeUtil(start, i - 1);
            List<TreeNode> rightTrees = generateTreeUtil(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

        return result;
    }

    @Test
    public void test_generateTrees() {
        UniqueBstGeneration solution = new UniqueBstGeneration();
        List<TreeNode> result = solution.generateTrees(3);
        for (TreeNode n : result) {
            BTreePrinter.printNode(n);
        }

    }
}
