package com.vcola.leetcode.puzzle;

/**
 * 136. 只出现一次的数字
 * 异或
 *
 * @author Very Cola
 * @date 2018年8月15日 上午9:12:19
 */
public class SingleNumber {

  public int singleNumber(int[] nums) {
    int result = nums[0];
    int length = nums.length;
    for (int i = 1; i < length; i++) {
      result ^= nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 1, 2, 1, 2 };
    System.out.println(new SingleNumber().singleNumber(nums));
  }

}
