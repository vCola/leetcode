package com.vcola.leetcode.puzzle;

/**
 * 70. 爬楼梯
 *
 * @author Very Cola
 * @date 2018年6月4日 上午8:51:58
 */
public class ClimbStairs {

  public static void main(String[] args) {
    ClimbStairs climbStairs = new ClimbStairs();
    System.out.println(climbStairs.climbStairs(0));
  }

  public int climbStairs(int n) {
    if (n == 0) {
      return 1;
    }
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

}
