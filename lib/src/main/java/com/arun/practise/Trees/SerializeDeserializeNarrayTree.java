package com.arun.practise.trees;

import org.junit.Test;

import java.util.ArrayList;

public class SerializeDeserializeNarrayTree {
    // Encodes a tree to a single string.

    public String serialize(TreeNode curr) {
        if (curr == null) return "";

        int childCount = curr.children == null ? 0 : curr.children.size();
        StringBuilder subTrees = new StringBuilder();
        if (childCount > 0 ) {

            for (int i = 0; i < curr.children.size(); i++) {
                subTrees.append(serialize((TreeNode) curr.children.get(i)));
            }
        }
        return curr.val + "," + childCount + "," + subTrees.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    @Test
    public void test_serialize() {
        SerializeDeserializeNarrayTree solution = new SerializeDeserializeNarrayTree();
        TreeNode root = new TreeNode(1);
        root.children = new ArrayList(3);
        TreeNode n = new TreeNode(3);
        n.children = new ArrayList(2);
        n.children.add(new TreeNode(5));
        n.children.add(new TreeNode(6));

        root.children.add(n);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(4));

        String result = solution.serialize(root);
        System.out.println(result);
    }
}
