package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * @author Very Cola
 * @date 2019年4月22日 下午4:20:02
 */
public class MinimumAbsoluteDifferenceInBST {

  public int getMinimumDifference(TreeNode root) {
    return getMinimumDifference(root, Integer.MAX_VALUE);
  }

  private int getMinimumDifference(TreeNode node, int min) {
    if (node == null) {
      return min;
    }

    if (node.left == null && node.right == null) {
      return min;
    }

    // 获取左侧的最大元素
    TreeNode maxLeft = node.left;
    while (maxLeft != null && maxLeft.right != null) {
      maxLeft = maxLeft.right;
    }
    if (maxLeft != null) {
      min = Math.min(min, node.val - maxLeft.val);
    }

    // 获取右侧的最小元素
    TreeNode minRight = node.right;
    while (minRight != null && minRight.left != null) {
      minRight = minRight.left;
    }
    if (minRight != null) {
      min = Math.min(min, minRight.val - node.val);
    }

    min = Math.min(min, getMinimumDifference(node.left, min));

    return Math.min(min, getMinimumDifference(node.right, min));
  }

  public static void main(String[] args) {
    Integer[] vals = { 236, 104, 701, null, 227, null, 911 };
    TreeNode root = TreeNode.valueOfLooselyArray(vals);
    MinimumAbsoluteDifferenceInBST bst = new MinimumAbsoluteDifferenceInBST();
    System.out.println(bst.getMinimumDifference(root));
  }

}
