package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.vcola.leetcode.common.TreeNode;

/**
 * 107. 二叉树的层次遍历 II
 *
 * @author Very Cola
 * @date 2018年6月13日 上午10:15:53
 */
public class BinaryTreeLevelOrderTraversal2_107 {

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
    LinkedList<List<Integer>> resultList = new LinkedList<>();
    if (root == null) {
      return resultList;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>(size);
      while (size-- > 0) {
        TreeNode treeNode = queue.poll();
        levelList.add(treeNode.val);
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }
      resultList.addFirst(levelList);
    }
    return resultList;
  }

  public List<List<Integer>> levelOrderBottomV1(TreeNode root) {
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
    TreeNode root = TreeNode.valueOf(3, 9, 20, null, null, 15, 7);
    List<List<Integer>> result = new BinaryTreeLevelOrderTraversal2_107().levelOrderBottom(root);
    System.out.println(result);
  }

}
