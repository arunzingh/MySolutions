package com.arun.practise.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateFullBt {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> trees = new ArrayList<>();
        if (n == 1) {
            trees.add(new TreeNode(0));
            return trees;
        }

        for (int i = 2; i <= n; i += 2) {
            List<TreeNode> leftTrees = allPossibleFBT(i - 1);
            List<TreeNode> rightTrees = allPossibleFBT( n - i);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }

        return trees;
    }

    @Test
    public void test_allPossibleFBT() {
        GenerateFullBt solution = new GenerateFullBt();
        List<TreeNode> result = solution.allPossibleFBT(7);
        for (TreeNode r : result) {
            BTreePrinter.printNode(r);
        }
    }
}
