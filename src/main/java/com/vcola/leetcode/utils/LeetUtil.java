package com.vcola.leetcode.utils;

import java.util.Random;

public class LeetUtil {

  private LeetUtil() {
  }

  public static boolean isSorted(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        return false;
      }
    }
    return true;
  }

  public static int[] randomArray(int length) {
    int[] nums = new int[length];
    Random random = new Random();
    for (int j = 0; j < length; j++) {
      nums[j] = random.nextInt(1000);
    }
    return nums;
  }
}
