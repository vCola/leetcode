package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 *
 * @author Very Cola
 * @date 2018年11月13日 上午9:37:05
 */
public class NAryTreeLevelOrderTraversal {

  // bfs dfs
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    List<Node> list = new ArrayList<>();
    list.add(root);

    List<Node> temp = new ArrayList<>();
    while (!list.isEmpty()) {
      temp.clear();
      List<Integer> elements = new ArrayList<>();
      for (Node node : list) {
        elements.add(node.val);
        temp.addAll(node.children);
      }
      result.add(elements);
      list = new ArrayList<>(temp);
    }

    return result;
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

}
