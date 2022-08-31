package com.learn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a binary tree, return an array containing nodes in its right view.
The right view of a binary tree is the set of nodes visible when the tree
is seen from the right side.
 */
class RightViewTree {
  public static List<TreeNode> traverse(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      int levelSize = q.size();
      List<TreeNode> currLevel = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++) {
        TreeNode curr = q.poll();
        currLevel.add(0, curr);
        if(curr.left != null) {
          q.offer(curr.left);
        }
        if(curr.right != null) {
          q.offer(curr.right);
        }
      }
      result.add(currLevel.get(0));
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
    root.left.left.left = new TreeNode(3);
    List<TreeNode> result = RightViewTree.traverse(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}