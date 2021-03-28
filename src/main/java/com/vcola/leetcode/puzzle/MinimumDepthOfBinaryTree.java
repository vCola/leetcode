package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 111. 二叉树的最小深度
 *
 * @author Very Cola
 * @date 2018年7月19日 上午9:36:06
 */
public class MinimumDepthOfBinaryTree {

  /**
   * 最小深度
   * 节点没有左右子节点才算完结
   *
   * @param root
   * @return
   */
  public int minDepth(TreeNode root) {
    return minDepth(root, 0);
  }

  private int minDepth(TreeNode node, int depth) {
    if (node == null) {
      return depth;
    }

    if (node.left == null) {
      return minDepth(node.right, depth + 1);
    }

    if (node.right == null) {
      return minDepth(node.left, depth + 1);
    }

    return Math.min(minDepth(node.left, depth + 1), minDepth(node.right, depth + 1));
  }

}
