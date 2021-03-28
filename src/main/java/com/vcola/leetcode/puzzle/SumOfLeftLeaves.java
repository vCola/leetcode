package com.vcola.leetcode.puzzle;

import java.util.Stack;

import com.vcola.leetcode.common.TreeNode;

/**
 * 404. 左叶子之和
 *
 * @author Very Cola
 * @date 2018年11月5日 下午5:03:49
 */
public class SumOfLeftLeaves {

  public int sumOfLeftLeaves(TreeNode root) {
    int sum = 0;
    if (root == null) {
      return sum;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null) {
          sum += node.left.val;
        }
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return sum;
  }

  public int sumOfLeftLeavesV2(TreeNode root) {
    return sum(0, root, false);
  }

  private int sum(int sum, TreeNode node, boolean isLeft) {
    if (node == null) {
      return sum;
    }

    if (isLeft && node.left == null && node.right == null) {
      sum += node.val;
    }

    return sum(sum, node.left, true) + sum(0, node.right, false);
  }

  public static void main(String[] args) {
    SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();

    Integer[] vals = { 3, 9, 20, 9, 90, 15, 7, 6, 7, 90 };
    TreeNode root = TreeNode.valueOf(vals);
    System.out.println(sumOfLeftLeaves.sumOfLeftLeavesV2(root));
    System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
  }

}
