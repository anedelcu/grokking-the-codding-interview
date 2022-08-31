package com.learn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, populate an array to represent the averages of all of its levels.
 */
class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()) {
      int levelSize = q.size();
      int sum = 0;
      for(int i = 0; i < levelSize; i++) {
        TreeNode temp = q.poll();
        sum += temp.val;
        if(temp.left != null) {
          q.offer(temp.left);
        }
        if(temp.right != null) {
          q.offer(temp.right);
        }
      }
      double avg = (double)sum / levelSize;
      result.add(avg);
    }


    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}