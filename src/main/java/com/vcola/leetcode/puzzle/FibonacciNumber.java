package com.vcola.leetcode.puzzle;

/**
 * 509. 斐波那契数
 *
 * @author Very Cola
 * @date 2019年4月8日 下午3:50:55
 */
public class FibonacciNumber {

  public int fib(int N) {
    if (N == 0) {
      return 0;
    }

    if (N == 1) {
      return 1;
    }

    int m = 0, n = 1;
    while (N-- > 1) {
      int temp = n;
      n = m + n;
      m = temp;
    }
    return n;
  }

  public static void main(String[] args) {
    FibonacciNumber fibonacciNumber = new FibonacciNumber();
    System.out.println(fibonacciNumber.fib(30));
  }
}
