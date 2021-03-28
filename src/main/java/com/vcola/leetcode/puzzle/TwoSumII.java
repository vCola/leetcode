package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author Very Cola
 * @date 2018年8月16日 下午6:10:22
 */
public class TwoSumII {

  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null) {
      return null;
    }

    int length = numbers.length;

    for (int i = 0; i < length; i++) {
      for (int j = length - 1; j > i; j--) {
        int temp = numbers[i] + numbers[j];
        if (temp < target) {
          break;
        } else if (temp == target) {
          return new int[] { i + 1, j + 1 };
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    int[] numbers = { 2, 7, 11, 15, 84 };
    System.out.println(Arrays.toString(new TwoSumII().twoSum(numbers, 99)));
  }

}
