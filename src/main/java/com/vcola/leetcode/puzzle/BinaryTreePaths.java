package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

import com.vcola.leetcode.common.TreeNode;

/**
 * 257. 二叉树的所有路径
 *
 * @author Very Cola
 * @date 2018年9月6日 上午9:08:28
 */
public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    path(root, result, "");
    return result;
  }

  private void path(TreeNode node, List<String> result, String path) {
    if (node == null) {
      return;
    }
    if ("".equals(path)) {
      path = path + node.val;
    } else {
      path = path + "->" + node.val;
    }
    if (node.left == null && node.right == null) {
      result.add(path);
      return;
    }
    path(node.left, result, path);
    path(node.right, result, path);
  }

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(new Integer[] { 1, 2, 3, null, 5 });
    BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
    System.out.println(binaryTreePaths.binaryTreePaths(root));
  }

}
