package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.vcola.leetcode.common.TreeNode;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author Very Cola
 * @date 2018年6月13日 上午10:15:53
 */
public class BinaryTreeLevelOrderTraversal2 {

  /**
   * 3
   * / \
   * 9  20
   * /  \
   * 15   7
   * 返回其自底向上的层次遍历为：
   * [
   * [15,7],
   * [9,20],
   * [3]
   * ]
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    LinkedList<TreeNode> preHeap = new LinkedList<>();
    LinkedList<TreeNode> heap = new LinkedList<>();
    preHeap.addFirst(root);

    List<Integer> temp = new ArrayList<>();
    while (!preHeap.isEmpty()) {
      TreeNode tempTreeNode = preHeap.removeLast();
      temp.add(tempTreeNode.val);

      if (tempTreeNode.left != null) {
        heap.addFirst(tempTreeNode.left);
      }

      if (tempTreeNode.right != null) {
        heap.addFirst(tempTreeNode.right);
      }

      if (preHeap.isEmpty()) {
        result.add(temp);
        temp = new ArrayList<>();
        preHeap = heap;
        heap = new LinkedList<>();
      }
    }

    Collections.reverse(result);
    return result;
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

    List<List<Integer>> result = new BinaryTreeLevelOrderTraversal2().levelOrderBottom(root);
    System.out.println(result);

  }

}
