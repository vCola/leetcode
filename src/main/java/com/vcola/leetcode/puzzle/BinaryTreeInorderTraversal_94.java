package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> resultList = new ArrayList<>();
    TreeNode treeNode = root;
    Stack<TreeNode> stack = new Stack<>();
    while (treeNode != null || !stack.isEmpty()) {
      while (treeNode != null) {
        stack.push(treeNode);
        treeNode = treeNode.left;
      }
      if (!stack.isEmpty()) {
        treeNode = stack.pop();
        // in order
        resultList.add(treeNode.val);
        treeNode = treeNode.right;
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOfLooselyArray(1, null, 2, 3);
    System.out.println(Arrays.toString(TreeNode.toLooselyArray(root)));
    List<Integer> resultList = new BinaryTreeInorderTraversal_94().inorderTraversal(root);
    System.out.println(resultList);
  }

}
