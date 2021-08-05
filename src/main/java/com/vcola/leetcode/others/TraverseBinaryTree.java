package com.vcola.leetcode.others;

import com.vcola.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TraverseBinaryTree {

  public void levelTraverse(TreeNode root) {
    if (root == null) {
      return;
    }
    // FIFO
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
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
    TreeNode curNode = node;
    while (curNode != null || !stack.isEmpty()) {
      // 一直遍历到不存在左子节点
      while (curNode != null) {
        // 打印
        System.out.print(curNode.val + " ");
        stack.push(curNode);
        curNode = curNode.left;
      }
      // 已经不存在左子节点, 弹出后判断右子节点
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        curNode = curNode.right;
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
    TreeNode curNode = node;
    while (curNode != null || !stack.isEmpty()) {
      // 直接干到当前节点最左
      while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.left;
      }
      // 走到这一步， 说明stack中第一个元素 已经没有左子树
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        System.out.print(curNode.val + " ");
        curNode = curNode.right;
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

  // 后序遍历
  public void postOrderTraverseWithStack(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curNode = node;
    TreeNode lastVisit = null;

    while (curNode != null || !stack.isEmpty()) {
      while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.left;
      }
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        // 当前节点没有右子树 或者 右子树已经遍历过
        if (curNode.right == null || curNode.right == lastVisit) {
          System.out.print(curNode.val + " ");
          lastVisit = curNode;
          curNode = null;
        } else {
          stack.push(curNode);
          curNode = curNode.right;
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
