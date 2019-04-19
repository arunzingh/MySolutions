package com.arun.practise.trees;

import org.junit.Test;

import java.util.Arrays;

public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode curr) {
        if (curr == null) {
            return "";
        }
        return curr.val + "," + serialize(curr.left) + serialize(curr.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strPre = data.split(",");
        int[] pre = new int[strPre.length];

        for (int i = 0; i < strPre.length; i++) {
            pre[i] = Integer.parseInt(strPre[i]);
        }

        System.out.println(Arrays.toString(pre));

        return constructBstPreOrderUtil(pre, 0, pre.length - 1);
    }

    private TreeNode constructBstPreOrderUtil(int[] pre, int start, int end) {
        TreeNode n = null;
        if (start <= end) {
            n = new TreeNode(pre[start]);

            int index = search(pre, start, end, pre[start]);

            n.left = constructBstPreOrderUtil(pre, start+1, index-1);
            n.right = constructBstPreOrderUtil(pre, index, end);
        }

        return n;
    }

    private int search(int[] pre, int start, int end, int k) {
        int index = start;
        while (index <= end && pre[index] <= k) {
            index++;
        }
        return index;
    }

    @Test
    public void test_serialize() {
        SerializeDeserializeBST solution = new SerializeDeserializeBST();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        String data = solution.serialize(root);
        System.out.println(data);

        BTreePrinter.printNode(deserialize(data));
    }
}

