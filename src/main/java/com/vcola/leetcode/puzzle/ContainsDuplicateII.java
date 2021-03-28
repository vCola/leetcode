package com.vcola.leetcode.puzzle;

/**
 * 219. 存在重复元素 II
 *
 * @author Very Cola
 * @date 2018年8月24日 上午9:20:36
 */
public class ContainsDuplicateII {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, 4));
  }

}
