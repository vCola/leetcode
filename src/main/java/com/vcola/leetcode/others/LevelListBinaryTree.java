package com.vcola.leetcode.others;

import com.vcola.leetcode.common.TreeNode;

import java.util.LinkedList;

public class LevelListBinaryTree {



  public void levelTraverse(TreeNode root) {
    if (root == null) {
      return;
    }
    // FIFO
    LinkedList<TreeNode> heap = new LinkedList<>();
    heap.offer(root);
    while (!heap.isEmpty()) {
      TreeNode node = heap.poll();
      System.out.println(node.val);
      if (node.left != null) {
        heap.offer(node.left);
      }
      if (node.right != null) {
        heap.offer(node.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(7, 5, 9, 3, 6, 8, 10);
    new LevelListBinaryTree().levelTraverse(root);
  }
}
