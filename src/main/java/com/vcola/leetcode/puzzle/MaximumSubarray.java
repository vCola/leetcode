package com.vcola.leetcode.puzzle;

/**
 * 53. 最大子序和
 *
 * @author Very Cola
 * @date 2018年5月29日 上午8:46:11
 */
public class MaximumSubarray {

  /**
   * O(n)
   */
  public int maxSubArray(int[] nums) {
    int result = Integer.MIN_VALUE;
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      if (temp < 0) {
        temp = nums[i];
      } else {
        temp += nums[i];
      }

      if (temp > result) {
        result = temp;
      }
    }
    return result;
  }

  /**
   * 递归算法
   */
  public int maxSubArrayRecursive(int[] nums) {
    return maxSub(nums, 0, nums.length - 1);
  }

  private int maxSub(int[] nums, int left, int right) {
    if (left == right) {
      return nums[left];
    }

    int mid = left + (right - left) / 2;

    int leftMaxSub = maxSub(nums, left, mid);
    int rightMaxSub = maxSub(nums, mid + 1, right);

    // 求左侧边界最大值
    int leftBorderMaxSub = Integer.MIN_VALUE;
    int leftBorderMaxSubTemp = 0;
    for (int i = mid; i >= left; i--) {
      leftBorderMaxSubTemp += nums[i];
      if (leftBorderMaxSubTemp > leftBorderMaxSub) {
        leftBorderMaxSub = leftBorderMaxSubTemp;
      }
    }

    // 求右侧边界最大值
    int rightBorderMaxSub = Integer.MIN_VALUE;
    int rightBorderMaxSubTemp = 0;
    for (int i = mid + 1; i <= right; i++) {
      rightBorderMaxSubTemp += nums[i];
      if (rightBorderMaxSubTemp > rightBorderMaxSub) {
        rightBorderMaxSub = rightBorderMaxSubTemp;
      }
    }

    return Math.max(leftMaxSub, Math.max(rightMaxSub, leftBorderMaxSub + rightBorderMaxSub));
  }

}
