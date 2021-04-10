package com.vcola.leetcode.others;

import com.vcola.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class TraverseBinaryTree {

  public void levelTraverse(TreeNode root) {
    if (root == null) {
      return;
    }
    // FIFO
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.pop();
      System.out.print(node.val + " ");
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }
  }

  public void preOrderTraverse(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.val + " ");
    preOrderTraverse(node.left);
    preOrderTraverse(node.right);
  }

  public void preOrderTraverseWithStack(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = node;
    while (treeNode != null || !stack.isEmpty()) {
      // 一直遍历到不存在左子节点
      while (treeNode != null) {
        // 打印
        System.out.print(treeNode.val + " ");
        stack.push(treeNode);
        treeNode = treeNode.left;
      }
      // 已经不存在左子节点, 弹出后判断右子节点
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        treeNode = treeNode.right;
      }
    }
  }

  public void inOrderTraverse(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrderTraverse(node.left);
    System.out.print(node.val + " ");
    inOrderTraverse(node.right);
  }

  public void inOrderTraverseWithStack(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = node;
    while (treeNode != null || !stack.isEmpty()) {
      while (treeNode != null) {
        stack.push(treeNode);
        treeNode = treeNode.left;
      }
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        System.out.print(treeNode.val + " ");
        treeNode = treeNode.right;
      }
    }
  }

  public void postOrderTraverse(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrderTraverse(node.left);
    postOrderTraverse(node.right);
    System.out.print(node.val + " ");
  }

  public void postOrderTraverseWithStack(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode treeNode = node;
    TreeNode lastVisit = null;

    while (treeNode != null || !stack.isEmpty()) {
      while (treeNode != null) {
        stack.push(treeNode);
        treeNode = treeNode.left;
      }
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        if (treeNode.right == null || treeNode.right == lastVisit) {
          System.out.print(treeNode.val + " ");
          lastVisit = treeNode;
          treeNode = null;
        } else {
          stack.push(treeNode);
          treeNode = treeNode.right;
        }
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(7, 5, 10, 3, 6, 8, 14);
    TraverseBinaryTree traverseBinaryTree = new TraverseBinaryTree();

    System.out.println("层序:");
    traverseBinaryTree.levelTraverse(root);
    System.out.println();

    System.out.println("前序递归:");
    traverseBinaryTree.preOrderTraverse(root);
    System.out.println();
    System.out.println("前序非递归:");
    traverseBinaryTree.preOrderTraverseWithStack(root);
    System.out.println();

    System.out.println("中序递归");
    traverseBinaryTree.inOrderTraverse(root);
    System.out.println();
    System.out.println("中序非递归");
    traverseBinaryTree.inOrderTraverseWithStack(root);
    System.out.println();

    System.out.println("后续递归");
    traverseBinaryTree.postOrderTraverse(root);
    System.out.println();
    System.out.println("后续非递归");
    traverseBinaryTree.postOrderTraverseWithStack(root);
  }
}
