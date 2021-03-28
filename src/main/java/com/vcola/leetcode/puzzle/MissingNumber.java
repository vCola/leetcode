package com.vcola.leetcode.puzzle;

/**
 * 268. 缺失数字 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? [3,0,1] -> 2
 *
 * @author Very Cola
 * @date 2018年9月11日 上午9:39:14
 */
public class MissingNumber {

  public int missingNumber(int[] nums) {
    if (nums.length == 1) {
      return 1 ^ nums[0];
    }

    int result = 0;
    int max = maxWithBitOfN(nums.length);
    for (int i = 0; i <= max; i++) {
      if (i < nums.length) {
        result ^= nums[i];
      } else if (i > nums.length) {
        result ^= i;
      }
    }
    return result;
  }

  private int maxWithBitOfN(int n) {
    n = (n >>> 1) | n;
    n = (n >>> 2) | n;
    n = (n >>> 4) | n;
    n = (n >>> 8) | n;
    n = (n >>> 16) | n;
    return n;
  }

  public static void main(String[] args) {
    MissingNumber missingNumber = new MissingNumber();
    int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1, 10, 11, 8 };
    System.out.println(missingNumber.missingNumber(nums));
  }

}
