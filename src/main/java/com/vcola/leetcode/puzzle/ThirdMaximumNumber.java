package com.vcola.leetcode.puzzle;

/**
 * 414. 第三大的数
 *
 * @author Very Cola
 * @date 2018年11月8日 上午9:45:18
 */
public class ThirdMaximumNumber {

  // 要求O(n)
  public int thirdMax(int[] nums) {
    int maxBiggest = Integer.MIN_VALUE;
    int maxBigger = Integer.MIN_VALUE;
    int maxBig = Integer.MIN_VALUE;

    int temp;
    boolean maxBigChanged = false;
    for (int i = 0; i < nums.length; i++) {
      temp = nums[i];

      if (temp == Integer.MIN_VALUE) {
        maxBigChanged = true;
      }

      if (temp == maxBiggest || temp == maxBigger || temp == maxBig) {
        continue;
      }

      if (temp > maxBiggest) {
        if (maxBigger != Integer.MIN_VALUE) {
          maxBigChanged = true;
        }
        maxBig = maxBigger;
        maxBigger = maxBiggest;
        maxBiggest = temp;
      } else if (temp > maxBigger) {
        if (maxBigger != Integer.MIN_VALUE) {
          maxBigChanged = true;
        }
        maxBig = maxBigger;
        maxBigger = temp;
      } else if (temp > maxBig) {
        maxBigChanged = true;
        maxBig = temp;
      }
    }

    if (maxBigChanged && maxBiggest > maxBigger && maxBigger > maxBig) {
      return maxBig;
    }
    return maxBiggest;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 2, 2 };

    ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
    System.out.println(thirdMaximumNumber.thirdMax(nums));
  }

}
