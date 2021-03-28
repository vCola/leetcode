package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 189. 旋转数组
 *
 * @author Very Cola
 * @date 2018年8月20日 上午9:55:56
 */
public class RotateArray {

  public void rotate(int[] nums, int k) {
    int length = nums.length;
    k %= length;
    if (k == 0) {
      return;
    }
    int count = 0;
    for (int i = 0; count < length; i++) {
      int currentIndex = i;
      int preValue = nums[currentIndex];
      do {
        int nextIndex = (currentIndex + k) % length;
        int temp = nums[nextIndex];
        nums[nextIndex] = preValue;
        preValue = temp;
        currentIndex = nextIndex;
        count++;
      } while (currentIndex != i);
    }
  }

  public void rotate02(int[] nums, int k) {
    int length = nums.length;
    k %= length;
    if (k == 0) {
      return;
    }
    int count = 0;
    for (int start = 0; count < length; start++) {
      int currentIndex = start;
      int preValue = nums[currentIndex];
      while (true) {
        int nextIndex = (currentIndex + k) % length;
        int temp = nums[nextIndex];
        nums[nextIndex] = preValue;
        preValue = temp;
        currentIndex = nextIndex;
        count++;
        if (currentIndex == start) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    new RotateArray().rotate02(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}
