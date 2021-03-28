package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author Very Cola
 * @date 2018年8月30日 上午9:36:54
 */
public class InvertBinaryTree {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    if (root.left != null || root.right != null) {
      TreeNode tempTreeNode = root.left;
      root.left = root.right;
      root.right = tempTreeNode;
      invertTree(root.left);
      invertTree(root.right);
    }
    return root;
  }

}
