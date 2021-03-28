package com.vcola.leetcode.puzzle;

/**
 * 198. 打家劫舍
 *
 * @author Very Cola
 * @date 2018年8月21日 上午9:05:31
 */
public class HouseRobber {

  public int rob(int[] nums) {
    int preMax = 0;
    int preValue = 0;
    int currentValue = 0;
    for (int i = 0; i < nums.length; i++) {
      int temp = currentValue;
      if (preMax < preValue) {
        preMax = preValue;
      }
      currentValue = preMax + nums[i];
      preValue = temp;
    }
    return currentValue > preValue ? currentValue : preValue;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 7, 1, 400, 402, 1, 9 };
    System.out.println(new HouseRobber().rob(nums));
  }

}
