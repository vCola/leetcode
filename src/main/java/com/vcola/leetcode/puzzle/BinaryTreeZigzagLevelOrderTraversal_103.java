package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<List<Integer>> resultList = new ArrayList<>();
    

    return resultList;
  }

  public static List<List<Integer>> zigzagLevelOrderV1(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> resultList = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> subResultList = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        subResultList.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      resultList.add(subResultList);
    }

    for (int i = 0; i < resultList.size(); i++) {
      // reverse
      if (i % 2 == 1) {
        Collections.reverse(resultList.get(i));
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    List<List<Integer>> resultList = zigzagLevelOrderV1(root);
    for (List<Integer> integers : resultList) {
      System.out.println(integers);
    }
  }

}
