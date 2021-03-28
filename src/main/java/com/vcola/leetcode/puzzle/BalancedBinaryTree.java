package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @author Very Cola
 * @date 2018年7月18日 上午9:33:58
 */
public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(maxDepth(root.left, 0) - maxDepth(root.right, 0)) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
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
    TreeNode root = new TreeNode(3);
    TreeNode left01 = new TreeNode(9);
    TreeNode right01 = new TreeNode(20);

    TreeNode left02 = new TreeNode(15);
    TreeNode right02 = new TreeNode(7);

    root.left = left01;
    root.right = right01;

    right01.left = left02;
    right01.right = right02;

    System.out.println(new BalancedBinaryTree().isBalanced(root));

  }

}
