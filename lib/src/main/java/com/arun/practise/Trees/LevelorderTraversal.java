package com.arun.practise.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelorderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> row = new ArrayList<>(currentLevelSize);
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode curr = queue.poll();
                row.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            result.add(row);
        }

        return result;
    }

    @Test
    public void test_levelOrder() {
        LevelorderTraversal solution = new LevelorderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);

        for (List<Integer> row : result) {
            System.out.print(row);
        }
    }
}
