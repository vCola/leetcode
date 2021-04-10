package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 100. 相同的树
 *
 * @author Very Cola
 * @date 2018年6月8日 上午9:04:30
 */
public class SameTree {

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    TreeNode left1 = new TreeNode(2);
    TreeNode right1 = new TreeNode(3);

    root1.left = left1;
    root1.right = right1;

    TreeNode root2 = new TreeNode(1);
    TreeNode left2 = new TreeNode(2);
    TreeNode right2 = new TreeNode(3);

    root2.left = left2;
    root2.right = right2;

    SameTree sameTree = new SameTree();
    System.out.println(sameTree.isSameTree(root1, root2));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (p == null || q == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    if (!isSameTree(p.left, q.left)) {
      return false;
    }

    return isSameTree(p.right, q.right);
  }
}
