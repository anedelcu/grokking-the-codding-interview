package com.learn.dfs;

import com.sun.source.tree.Tree;

/*
Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes
on the longest path between any two leaf nodes. The diameter of a tree may or may not pass through the root.

Note: You can always assume that there are at least two leaf nodes in the given tree.

Example 1:  [1, 2, 3, null, 4, 5, 6]
Output: 5
Explanation: The diameter of the tree is: [4, 2, 1, 3, 6]

Example 2: [1, 2, 3, null, null, 5, 6, null, 7, 8, 9, null, null, null, 10, 11, null]
Output: 7
Explanation: The diameter of the tree is: [10, 8, 5, 3, 6, 9, 11]
 */
public class TreeDiameter {

    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }

    private static int calculateHeight(TreeNode curr) {
        if(curr == null) {
            return 0;
        }

        int leftHeight = calculateHeight(curr.left);
        int rightHeight = calculateHeight(curr.right);

        // if the current node doesn't have a left or right subtree, we can't have
        // a path passing through it, since we need a leaf node on each side
        if(leftHeight != 0 && rightHeight != 0) {

            // diameter at the current node will be equal to the height of the left subtree +
            // the height of the right subtree + 1 for the current node
            int diameter = leftHeight + rightHeight + 1;

            // update the global tree diameter
            treeDiameter = Math.max(treeDiameter, diameter);
        }

        // height of the current node will be equal tot he maximum of the heights of
        // left or right subtrees plus '1' for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
