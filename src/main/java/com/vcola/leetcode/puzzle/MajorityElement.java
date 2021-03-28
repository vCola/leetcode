package com.vcola.leetcode.puzzle;

/**
 * 169. 求众数
 *
 * @author Very Cola
 * @date 2018年8月17日 上午9:48:59
 */
public class MajorityElement {

  public int majorityElement(int[] nums) {
    int result = nums[0];
    int times = 1;
    for (int i = 1; i < nums.length; i++) {
      if (times == 0) {
        result = nums[i];
        times = 1;
      } else {
        if (nums[i] == result) {
          times++;
        } else {
          times--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 6, 5, 5 };
    System.out.println(new MajorityElement().majorityElement(nums));
  }
}
