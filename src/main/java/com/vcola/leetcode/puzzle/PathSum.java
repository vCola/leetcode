package com.vcola.leetcode.puzzle;

import java.util.Stack;

import com.vcola.leetcode.common.TreeNode;

/**
 * 112. 路径总和
 * 到叶节点
 *
 * @author Very Cola
 * @date 2018年7月20日 上午9:30:00
 */
public class PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    Stack<TreeNode> stack = new Stack<>();
    Stack<Integer> sumStack = new Stack<>();
    stack.push(root);
    sumStack.push(0);

    while (!stack.isEmpty()) {
      TreeNode currentNode = stack.pop();
      int currentSum = sumStack.pop() + currentNode.val;
      if (currentNode.right == null && currentNode.left == null) {
        if (currentSum == sum) {
          return true;
        }
        continue;
      }

      if (currentNode.right != null) {
        stack.push(currentNode.right);
        sumStack.push(currentSum);
      }
      if (currentNode.left != null) {
        stack.push(currentNode.left);
        sumStack.push(currentSum);
      }
    }
    return false;
  }
	
	/*private boolean hasPathSum(TreeNode node, int sum, int currentSum) {
		if(node == null){
			return false;
		}
		
		currentSum += node.val;
		
		if(node.left == null && node.right == null){
			return sum == currentSum;
		}
		return hasPathSum(node.left, sum, currentSum) || hasPathSum(node.right, sum, currentSum);
	}*/

  public static void main(String[] args) {
    TreeNode root = TreeNode.valueOf(new Integer[] { -2, null, -3 });
    System.out.println(new PathSum().hasPathSum(root, -5));
  }
}