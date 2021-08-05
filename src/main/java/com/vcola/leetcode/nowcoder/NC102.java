package com.vcola.leetcode.nowcoder;

import com.vcola.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NC102 {

  public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
    List<TreeNode> path1 = path(root, o1);
    List<TreeNode> path2 = path(root, o2);
    int index = 0;
    int resultIndex = 0;
    while (index < path1.size() && index < path2.size()) {
      if (path1.get(index) == path2.get(index)) {
        resultIndex = index;
      }
      index++;
    }
    return path1.get(resultIndex).val;
  }

  private static List<TreeNode> path(TreeNode root, int val) {
    Stack<TreeNode> stack = new Stack<>();
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    TreeNode curNode = root;
    TreeNode foundNode = null;
    while (foundNode == null && (curNode != null || !stack.isEmpty())) {
      while (curNode != null) {
        stack.push(curNode);
        if (curNode.val == val) {
          foundNode = curNode;
          break;
        }
        if (curNode.left != null) {
          parentMap.put(curNode.left.val, curNode);
        }
        curNode = curNode.left;
      }
      if (foundNode == null && !stack.isEmpty()) {
        curNode = stack.pop();
        if (curNode.right != null) {
          parentMap.put(curNode.right.val, curNode);
        }
        curNode = curNode.right;
      }
    }
    LinkedList<TreeNode> path = new LinkedList<>();
    TreeNode cur = foundNode;
    while (cur != null) {
      path.addFirst(cur);
      cur = parentMap.get(cur.val);
    }
    return path;
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<TreeNode> path = path(root, 10);
    for (TreeNode treeNode : path) {
      System.out.print(treeNode.val + "->");
    }
  }
}
