package com.learn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level from left to right,
then right to left for the next level and keep alternating in the same manner for the following levels.
 */
class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int level = 0;
    while(!q.isEmpty()) {
      int levelSize = q.size();
      List<Integer> currLevel = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++) {
        TreeNode temp = q.poll();
        if(level % 2 == 0) {
          currLevel.add(temp.val);
        }
        else {
          currLevel.add(0, temp.val);
        }
        if(temp.left != null) {
          q.offer(temp.left);
        }
        if(temp.right != null) {
          q.offer(temp.right);
        }
      }
      result.add(currLevel);
      level++;
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}