package com.vcola.leetcode.nowcoder;

import com.vcola.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ThreeOrdersTreeNode {

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(7, 5, 10, 3, 6, 8, 14);
    orderRecur(root);
    System.out.println();
    System.out.println(postOrder(root));
  }

  private static void orderRecur(TreeNode root) {
    if (root == null) {
      return;
    }
    orderRecur(root.left);
    orderRecur(root.right);
    System.out.print(root.val + ", ");
  }

  public int[][] threeOrders(TreeNode root) {
    int[][] result = new int[3][];
    if (root == null) {
      return result;
    }
    result[0] = toArray(preOrder(root));
    result[1] = toArray(inOrder(root));
    result[2] = toArray(postOrder(root));
    return result;
  }

  private static List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curNode = root;
    while (curNode != null || !stack.isEmpty()) {
      while (curNode != null) {
        result.add(curNode.val);
        stack.push(curNode);
        curNode = curNode.right;
      }
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        curNode = curNode.left;
      }
    }
    Collections.reverse(result);
    return result;
  }

  private static List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curNode = root;
    while (curNode != null || !stack.isEmpty()) {
      while (curNode != null) {
        stack.push(curNode);
        curNode = curNode.left;
      }
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        result.add(curNode.val);
        curNode = curNode.right;
      }
    }
    return result;
  }

  private static List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curNode = root;
    while (curNode != null || !stack.isEmpty()) {
      while (curNode != null) {
        result.add(curNode.val);
        stack.push(curNode);
        curNode = curNode.left;
      }
      if (!stack.isEmpty()) {
        curNode = stack.pop();
        curNode = curNode.right;
      }
    }
    return result;
  }

  private int[] toArray(List<Integer> list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }
}
