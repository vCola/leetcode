package com.vcola.leetcode.puzzle;

/**
 * 342. 4的幂
 *
 * @author Very Cola
 * @date 2018年9月17日 上午11:51:06
 */
public class PowerOfFour {

  public boolean isPowerOfFour(int num) {
    double result = Math.log10(num) / Math.log10(4);
    return ((int) result - result) == 0;
  }

}
