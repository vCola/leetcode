package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * @author Very Cola
 * @date 2018年5月30日 上午9:16:10
 */
public class PlusOne {

  public int[] plusOne(int[] digits) {
    if (digits == null) {
      return null;
    }
    int index = digits.length - 1;
    while (index >= 0) {

      int temp = digits[index] + 1;
      if (temp < 10) {
        digits[index] = temp;
        break;
      }

      digits[index] = temp % 10;

      if (index == 0) {
        int[] dest = new int[digits.length + 1];
        System.arraycopy(digits, 0, dest, 1, digits.length);
        dest[0] = 1;
        digits = dest;
      }

      index--;
    }
    return digits;
  }

  public static void main(String[] args) {
    PlusOne plusOne = new PlusOne();
    int[] digits = { -9 };

    digits = plusOne.plusOne(digits);

    System.out.println(Arrays.toString(digits));
  }

}
