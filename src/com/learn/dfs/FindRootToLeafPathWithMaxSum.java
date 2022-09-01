package com.learn.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Given a binary tree, find the root-to-leaf path with the maximum sum.
 */
public class FindRootToLeafPathWithMaxSum {
    static int maxSum = Integer.MIN_VALUE;
    public static List<Integer> maxPath;
    public static List<Integer> findPathWithMaxSum(TreeNode root, int sum) {
        List<Integer> maxPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        return findPathsRecursive(root, 0, currentPath);
    }

    private static List<Integer> findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath) {
        //List<Integer> maxPath = new ArrayList<>(currentPath);
        if (currentNode == null)
            return maxPath;
        // add the current node to the path
        currentPath.add(currentNode.val);
        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val + sum > maxSum && currentNode.left == null && currentNode.right == null) {
            maxPath = new ArrayList<>(currentPath);
            System.out.println();
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum + currentNode.val, currentPath);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum + currentNode.val, currentPath);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
        return maxPath;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(20);
        List<Integer> result = FindRootToLeafPathWithMaxSum.findPathWithMaxSum(root, 0);
        System.out.println("Tree path with sum: " + result);
    }
}