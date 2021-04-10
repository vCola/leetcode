package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @author Very Cola
 * @date 2018年7月17日 上午9:48:56
 */
public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return sortedArrayToBST(0, nums.length - 1, nums);
  }

  private TreeNode sortedArrayToBST(int left, int right, int[] nums) {
    if (left == right) {
      return new TreeNode(nums[left]);
    }
    if (left > right) {
      return null;
    }

    int mid = (right - left) / 2 + left;
    TreeNode root = new TreeNode(nums[mid]);

    // build left
    root.left = sortedArrayToBST(left, mid - 1, nums);
    // build right
    root.right = sortedArrayToBST(mid + 1, right, nums);

    return root;
  }

  public static void main(String[] args) {
    int[] nums = { -10, -3, 0, 5, 9 };
    TreeNode root = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
    System.out.println(new BinaryTreeLevelOrderTraversal2_107().levelOrderBottom(root));
  }

}
