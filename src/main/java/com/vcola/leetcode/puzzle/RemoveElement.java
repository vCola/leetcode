package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * @author Very Cola
 * @date 2018年5月26日 上午7:38:45
 */
public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int length = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        if (length != i) {
          nums[length] = nums[i];
        }
        length++;
      }
    }

    return length;
  }

  public static void main(String[] args) {

    RemoveElement removeElement = new RemoveElement();

    int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int val = 2;

    System.out.println(removeElement.removeElement(nums, val));

    System.out.println(Arrays.toString(nums));

  }

}
