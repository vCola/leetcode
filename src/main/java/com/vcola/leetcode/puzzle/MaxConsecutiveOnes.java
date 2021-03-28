package com.vcola.leetcode.puzzle;

/**
 * 485. 最大连续1的个数
 *
 * @author Very Cola
 * @date 2018年12月13日 上午10:02:58
 */
public class MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int result = 0, temp = 0;
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      if (nums[i] == 0) {
        if (temp > result) {
          result = temp;
        }
        temp = 0;
      } else {
        temp++;
      }
    }

    return Math.max(result, temp);
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 };
    MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
    System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
  }

}
