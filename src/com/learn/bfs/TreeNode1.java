package com.learn.bfs;

import java.util.*;
/*
Given a binary tree, connect each node with its level order successor.
The last node of each level should point to a null node.
 */
class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1 next;

  TreeNode1(int x) {
    val = x;
    left = right = next = null;
  }

  // level order traversal using 'next' pointer
  void printLevelOrder() {
    TreeNode1 nextLevelRoot = this;
    while (nextLevelRoot != null) {
      TreeNode1 current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};

class ConnectLevelOrderSiblings {

  public static void connect(TreeNode1 root) {
    if(root == null) {
      return;
    }
    Queue<TreeNode1> q = new LinkedList<>();
    q.offer(root);
    while(!q.isEmpty()) {
      TreeNode1 prev = null;
      int levelSize = q.size();


      for(int i = 0; i < levelSize; i++) {
        TreeNode1 curr = q.poll();
        if(prev != null) {
          prev.next = curr;
        }
        prev = curr;
        if(curr.left != null) {
          q.offer(curr.left);
        }
        if(curr.right != null) {
          q.offer(curr.right);
        }
      }
    }
  }

  public static void main(String[] args) {
    TreeNode1 root = new TreeNode1(12);
    root.left = new TreeNode1(7);
    root.right = new TreeNode1(1);
    root.left.left = new TreeNode1(9);
    root.right.left = new TreeNode1(10);
    root.right.right = new TreeNode1(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}