package com.arun.practise.trees;

import org.junit.Test;

public class SerializeDeserializeBT {
    // Encodes a tree to a single string.
    public String serialize(TreeNode curr) {
        if (curr == null) {
            return "N,";
        }

        return curr.val + "," + serialize(curr.left) + serialize(curr.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        return null;
    }


    @Test
    public void test_serialize() {
        SerializeDeserializeBT solution = new SerializeDeserializeBT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        BTreePrinter.printNode(root);

        String data = solution.serialize(root);

        System.out.println(data);

        BTreePrinter.printNode(solution.deserialize(data));
    }
}
