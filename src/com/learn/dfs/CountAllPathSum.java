package com.learn.dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
Given a binary tree and a number ‘S’, find all paths in the tree
such that the sum of all the node values of each path equals ‘S’.
Please note that the paths can start or end at any node but all
paths must follow direction from parent to child (top to bottom).

Example 1:
1,7,9,6,5,2,3
S: 12
Output: 3
Explanation: There are three paths with sum '12': 7 -> 5, 1 -> 9 -> 2, and 9 -> 3

Example 2:
12,7,1,4,10,5
S: 11
Output: 2
Explanation: Here are the two paths with sum '11': 7 -> 4 . and 1 -> 10.
 */
public class CountAllPathSum {

    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsrecursive(root, S, currentPath);
    }

    private static int countPathsrecursive(TreeNode curr, int s, List<Integer> currentPath) {
        if(curr == null) {
            return 0;
        }

        // add the current node to the path
        currentPath.add(curr.val);
        int pathCount = 0;
        int pathSum = 0;
        // find the sum of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while(pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equaks to S we incremenet out path count;
            if(pathSum == s) {
                pathCount++;
            }
        }
        // traverse the left sub-tree
        pathCount += countPathsrecursive(curr.left, s, currentPath);
        // traverse the right sub-tree
        pathCount += countPathsrecursive(curr.right, s, currentPath);

        // remeove the current node from the path to backtrack
        // we need to remove the current node while we are going up the recursive call stack
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
