package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vcola.leetcode.common.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @author Very Cola
 * @date 2018年11月13日 下午3:25:21
 */
public class PathSumIII {

  public int pathSum(TreeNode root, int sum) {
    List<TreeNode> nodeList = new ArrayList<>();
    nodeList.add(root);
    int count = 0;

    List<TreeNode> tempList = new ArrayList<>();
    while (!nodeList.isEmpty()) {
      tempList.clear();
      for (TreeNode treeNode : nodeList) {
        count += pathSum(treeNode, sum, 0);
        if (treeNode != null) {
          tempList.add(treeNode.left);
          tempList.add(treeNode.right);
        }
      }
      nodeList = new ArrayList<>(tempList);
    }
    return count;
  }

  private int pathSum(TreeNode node, int sum, int currentSum) {
    if (node == null) {
      return 0;
    }

    int count = 0;
    currentSum += node.val;
    if (currentSum == sum) {
      count = 1;
    }
    return count + pathSum(node.left, sum, currentSum) + pathSum(node.right, sum, currentSum);
  }

  public static void main(String[] args) {
    Integer[] vals = new Integer[] { 10, 5, -3, 3, 2, null, 1, 3, -2, null, 1, 6, 9, 11, 12, 6, 9, null, null, 4, 9 };
    // vals = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};

    TreeNode root = TreeNode.valueOfLooselyArray(vals);
    System.out.println(Arrays.toString(vals));
    System.out.println(Arrays.toString(TreeNode.toLooselyArray(root)));

    PathSumIII pathSumIII = new PathSumIII();
    System.out.println(pathSumIII.pathSum(root, 8));
  }
}
