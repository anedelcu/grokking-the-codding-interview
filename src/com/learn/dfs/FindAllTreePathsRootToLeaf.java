package com.learn.dfs;

import java.util.ArrayList;
import java.util.List;
/*
 Given a binary tree, return all root-to-leaf paths.
 */
public class FindAllTreePathsRootToLeaf {
    public static List<List<Integer>> findPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = FindAllTreePathsRootToLeaf.findPaths(root);
        System.out.println("Tree paths root to leaf: " + result);
    }
}
