package com.vcola.leetcode.puzzle;

/**
 * 367. 有效的完全平方数
 *
 * @author Very Cola
 * @date 2018年9月28日 下午1:56:42
 */
public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    if (num < 0) {
      return false;
    }

    if (num == 0 || num == 1) {
      return true;
    }

    int low = 0, hi = num > 46340 ? 46340 : num;
    int mid;
    while (low <= hi) {
      mid = (hi - low) / 2 + low;
      int result = mid * mid;
      if (result > num) {
        hi = mid - 1;
      } else if (result < num) {
        low = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }

  int i = 2147395600;

  public static void main(String[] args) {
    System.out.println(new ValidPerfectSquare().isPerfectSquare(2147395600));
  }

}
