package com.vcola.leetcode.puzzle;

/**
 * 231. 2的幂
 *
 * @author Very Cola
 * @date 2018年9月5日 上午11:35:19
 */
public class PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    if (n < 1) {
      return false;
    }
    return ((n - 1) & n) == 0;
  }

  public static void main(String[] args) {
    PowerOfTwo powerOfTwo = new PowerOfTwo();
    System.out.println(powerOfTwo.isPowerOfTwo(16));
  }

}
