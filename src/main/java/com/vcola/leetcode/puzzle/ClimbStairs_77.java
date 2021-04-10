package com.vcola.leetcode.puzzle;

/**
 * 70. 爬楼梯
 *
 * @author Very Cola
 * @date 2018年6月4日 上午8:51:58
 */
public class ClimbStairs_77 {

  public int climbStairs(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    // f(n) = f(n-1) + f(n-2);
    int n1 = 1;
    int n2 = 2;
    int result = 0;
    while (n-- >= 3) {
      result = n1 + n2;
      n1 = n2;
      n2 = result;
    }
    return result;
  }

  public int climbStairsV1(int n) {
    if (n == 0) {
      return 1;
    }
    // [0, n]
    int[] steps = new int[n + 1];
    return climbStairs(n, steps);
  }

  private int climbStairs(int n, int[] steps) {
    if (steps[n] > 0) {
      return steps[n];
    }
    int step = 0;
    if (n == 1) {
      step = 1;
    } else if (n == 2) {
      step = 2;
    } else {
      step = climbStairs(n - 1, steps) + climbStairs(n - 2, steps);
    }
    steps[n] = step;
    return step;
  }

  public static void main(String[] args) {
    ClimbStairs_77 climbStairs = new ClimbStairs_77();
    for (int i = 1; i < 10; i++) {
      System.out.println(climbStairs.climbStairsV1(i));
    }
  }
}
