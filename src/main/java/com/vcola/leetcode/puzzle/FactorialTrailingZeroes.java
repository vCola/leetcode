package com.vcola.leetcode.puzzle;

/**
 * 172. 阶乘后的零
 *
 * @author Very Cola
 * @date 2018年8月17日 上午10:26:39
 */
public class FactorialTrailingZeroes {

  public int trailingZeroes(int n) {
    int result = 0;
    int temp = n / 5;
    while (temp != 0) {
      result += temp;
      temp = temp / 5;
    }
    return result;
  }

}
