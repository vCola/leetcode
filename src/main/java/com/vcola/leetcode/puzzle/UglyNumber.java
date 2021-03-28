package com.vcola.leetcode.puzzle;

/**
 * 263. 丑数
 *
 * @author Very Cola
 * @date 2018年9月11日 上午9:23:34
 */
public class UglyNumber {

  public boolean isUgly(int num) {
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
    UglyNumber uglyNumber = new UglyNumber();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i <= 1000000; i++) {
      if (uglyNumber.isUgly(i)) {
        System.out.println(i);
      }
    }
    System.out.println(String.format("共耗时 %s 毫秒", System.currentTimeMillis() - startTime));
  }

}
