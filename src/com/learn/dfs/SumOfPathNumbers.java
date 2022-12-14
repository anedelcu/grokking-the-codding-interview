package com.learn.dfs;
/*
Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
Find the total sum of all the numbers represented by all paths.
Example 1:
    1
  7   9
    2   9

Output: 408 Explanation: The sum of all path numbers: 17 + 192 + 199
 */
class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findRootToLeafPathNumbers(root, 0);
  }

  private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
    if (currentNode == null)
      return 0;

    // calculate the path number of the current node
    pathSum = 10 * pathSum + currentNode.val;

    // if the current node is a leaf, return the current path sum.
    if (currentNode.left == null && currentNode.right == null) {
      return pathSum;
    }

    // traverse the left and the right sub-tree
    return findRootToLeafPathNumbers(currentNode.left, pathSum) +
           findRootToLeafPathNumbers(currentNode.right, pathSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}