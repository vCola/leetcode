package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author Very Cola
 * @date 2018年9月13日 上午9:45:19
 */
public class MoveZeroes {

  // [0,1,0,3,12] -> [1,3,12,0,0]
  public void moveZeroes(int[] nums) {
    int zeroStartIndex = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (zeroStartIndex == -1) {
          zeroStartIndex = i;
        }
      } else {
        if (zeroStartIndex != -1) {
          // swap
          nums[zeroStartIndex++] = nums[i];
          nums[i] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 0, 1 };
    new MoveZeroes().moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

}
