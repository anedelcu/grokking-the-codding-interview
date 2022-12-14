package com.learn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, populate an array to represent its level-by-level traversal.
You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
class LevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int levelSize = 0;
    while(!q.isEmpty()) {
      levelSize = q.size();
      List<Integer> currLevel = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++) {
        TreeNode currNode = q.poll();
        currLevel.add(currNode.val);
        if(currNode.left != null) {
        q.offer(currNode.left);
        }
        if(currNode.right != null) {
          q.offer(currNode.right);
        }
      }
      result.add(currLevel);
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
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}