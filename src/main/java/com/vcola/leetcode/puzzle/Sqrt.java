package com.vcola.leetcode.puzzle;

/**
 * 69. x 的平方根
 *
 * @author Very Cola
 * @date 2018年6月1日 上午9:03:19
 */
public class Sqrt {

  /**
   * 2147483647
   * 超出时间限制
   *
   * @param x
   * @return
   */
  public int mySqrt(int x) {
    int guess = 0;
    while (guess <= x) {
      int temp = guess * guess;
      if (temp == x) {
        return guess;
      } else if (temp < x && ((guess + 1) * (guess + 1)) > x) {
        return guess;
      }
      guess++;
    }

    return guess;
  }

  /**
   * 牛顿逼近法
   *
   * @param x
   * @return
   */
  public int mySqrt02(int x) {
    if (x == 0) {
      return 0;
    }

    double guess = 1.0d;
    while (Math.abs(guess * guess - x) > 0.1) {
      guess = ((x / guess) + guess) / 2;
    }
    return (int) Math.floor(guess);
  }

  public static void main(String[] args) {

    Sqrt sqrt = new Sqrt();

    System.out.println(sqrt.mySqrt02(2147483647));
  }

}
