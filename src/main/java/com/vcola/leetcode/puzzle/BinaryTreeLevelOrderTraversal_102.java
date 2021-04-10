package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> resultList = new ArrayList<>();
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
      if (!levelList.isEmpty()) {
        resultList.add(levelList);
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(3, 9, 20, null, null, 15, 7);
    List<List<Integer>> resultList = new BinaryTreeLevelOrderTraversal_102().levelOrder(root);
    resultList.forEach(System.out::println);
  }

}
