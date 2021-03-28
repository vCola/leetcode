package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import com.vcola.leetcode.common.TreeNode;

/**
 * 501. 二叉搜索树中的众数
 *
 * @author Very Cola
 * @date 2018年12月14日 下午3:01:55
 */
public class FindModeInBinarySearchTree {

  public int[] findModeV1(TreeNode root) {
    if (root == null) {
      return new int[] {};
    }

    Map<Integer, Integer> map = new HashMap<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      Integer count = map.get(node.val);
      if (count == null) {
        count = 1;
      } else {
        count++;
      }
      map.put(node.val, count);
      if (node.left != null) {
        stack.push(node.left);
      }

      if (node.right != null) {
        stack.push(node.right);
      }
    }

    List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, (e1, e2) -> {
      return e2.getValue() - e1.getValue();
    });

    List<Integer> resultList = new ArrayList<>();
    resultList.add(list.get(0).getKey());
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i).getValue() < list.get(0).getValue()) {
        break;
      }
      resultList.add(list.get(i).getKey());
    }

    int[] result = new int[resultList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = resultList.get(i);
    }

    return result;
  }

  Integer preVal;
  int count = 1, max = 0;

  public int[] findMode(TreeNode root) {
    if (root == null) {
      return new int[] {};
    }

    List<Integer> resultList = new ArrayList<>();
    dfs(resultList, root);

    int[] result = new int[resultList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }

  private void dfs(List<Integer> resultList, TreeNode node) {
    if (node == null) {
      return;
    }

    dfs(resultList, node.left);
    if (preVal != null) {
      if (preVal == node.val) {
        count++;
      } else {
        count = 1;
      }
    }

    if (count == max) {
      resultList.add(node.val);
    } else if (count > max) {
      resultList.clear();
      max = count;
      resultList.add(node.val);
    }
    preVal = node.val;
    dfs(resultList, node.right);
  }

  public static void main(String[] args) {
    Integer[] vals = { 1, null, 2, 2 };
    TreeNode root = TreeNode.valueOfLooselyArray(vals);

    FindModeInBinarySearchTree findModeInBinarySearchTree = new FindModeInBinarySearchTree();
    System.out.println(Arrays.toString(findModeInBinarySearchTree.findMode(root)));
  }
}
