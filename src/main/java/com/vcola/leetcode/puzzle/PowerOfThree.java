package com.vcola.leetcode.puzzle;

/**
 * 326. 3的幂
 *
 * @author Very Cola
 * @date 2018年9月17日 上午11:34:42
 */
public class PowerOfThree {

  public boolean isPowerOfThree(int n) {
    double result = Math.log10(n) / Math.log10(3);
    return ((int) result - result) == 0;
  }

}
