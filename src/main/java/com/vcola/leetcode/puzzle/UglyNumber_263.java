package com.vcola.leetcode.puzzle;

/**
 * 263. 丑数
 *
 * @author Very Cola
 * @date 2018年9月11日 上午9:23:34
 */
public class UglyNumber_263 {

  public boolean isUgly(int n) {
    if (n <= 0) {
      return false;
    }
    int[] factors = { 2, 3, 5 };
    for (int factor : factors) {
      while (n % factor == 0) {
        n /= factor;
      }
    }
    return n == 1;
  }

  public boolean isUglyV1(int num) {
    if (num == 0) {
      return false;
    }

    while (num % 2 == 0) {
      num = num / 2;
    }

    while (num % 3 == 0) {
      num = num / 3;
    }

    while (num % 5 == 0) {
      num = num / 5;
    }

    return num == 1;
  }

  public static void main(String[] args) {
    UglyNumber_263 uglyNumber = new UglyNumber_263();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i <= 1000000; i++) {
      if (uglyNumber.isUgly(i)) {
        System.out.println(i);
      }
    }
    System.out.println(String.format("共耗时 %s 毫秒", System.currentTimeMillis() - startTime));
  }

}
