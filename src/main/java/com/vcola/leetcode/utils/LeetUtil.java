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

  public static int[] randomArray(int length, int bound) {
    int[] nums = new int[length];
    Random random = new Random();
    for (int j = 0; j < length; j++) {
      nums[j] = random.nextInt(bound);
    }
    return nums;
  }

  public static int[] randomArray(int length) {
    return randomArray(length, 1000);
  }

  public static int[] randomUkArray(int length, int bound) {
    if (length > bound) {
      throw new IllegalArgumentException("length is larger than bound");
    }
    int[] nums = new int[length];
    boolean[] flags = new boolean[bound];
    Random random = new Random();
    for (int j = 0; j < length; j++) {
      int temp = random.nextInt(bound);
      while (flags[temp]) {
        temp = random.nextInt(bound);
      }
      flags[temp] = true;
      nums[j] = temp;
    }
    return nums;
  }

  public static int[] randomUkArray(int length) {
    int bound = length > 1000 ? length << 2 : 1000;
    return randomUkArray(length, bound);
  }

}
