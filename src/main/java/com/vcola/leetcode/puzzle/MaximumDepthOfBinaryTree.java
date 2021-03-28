package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 *
 * @author Very Cola
 * @date 2018年6月11日 上午9:24:45
 */
public class MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    return maxDepth(root, 0);
  }

  private int maxDepth(TreeNode node, int depth) {
    if (node == null) {
      return depth;
    }

    int maxLeftDepth = maxDepth(node.left, depth + 1);

    int maxRightDepth = maxDepth(node.right, depth + 1);

    return Math.max(maxLeftDepth, maxRightDepth);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left1 = new TreeNode(2);
    TreeNode left2 = new TreeNode(3);
    root.left = left1;
    left1.left = left2;
    MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
    System.out.println(maximumDepthOfBinaryTree.maxDepth(root));
  }
}
