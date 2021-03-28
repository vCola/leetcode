package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * @author Very Cola
 * @date 2018年9月5日 下午5:12:02
 */
public class LowestCommonAncestorOfBinarySearchTree {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val > q.val) {
      TreeNode tempNode = p;
      p = q;
      q = tempNode;
    }

    return lowestCommonAncestor(root, p.val, q.val);
  }

  private TreeNode lowestCommonAncestor(TreeNode node, int val, int val2) {
    if (node.val == val || node.val == val2) {
      return node;
    }

    if (node.val > val && node.val < val2) {
      return node;
    }

    if (node.val > val && node.val > val2) {
      return lowestCommonAncestor(node.left, val, val2);
    } else {
      return lowestCommonAncestor(node.right, val, val2);
    }
  }

  public static void main(String[] args) {
    LowestCommonAncestorOfBinarySearchTree lowestCommonAncestorOfBinarySearchTree = new LowestCommonAncestorOfBinarySearchTree();
    TreeNode root = TreeNode.valueOf(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
    TreeNode p = new TreeNode(4);
    TreeNode q = new TreeNode(2);
    System.out.println(lowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(root, p, q).val);
  }

}
