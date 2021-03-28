package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 453. 最小移动次数使数组元素相等
 *
 * @author Very Cola
 * @date 2018年11月23日 下午6:04:43
 */
public class MinimumMovesToEqualArrayElements {

  /**
   * 从最简单的例子找规律
   *
   * @param nums
   * @return
   */
  public int minMoves(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    int init = nums[0];
    int length = nums.length;
    for (int i = 1; i < length; i++) {
      result += (nums[i] - init);
    }
    return result;
  }
}
