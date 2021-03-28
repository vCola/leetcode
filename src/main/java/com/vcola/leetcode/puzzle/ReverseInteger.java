package com.vcola.leetcode.puzzle;

/**
 * 7. 反转整数
 *
 * @author Very Cola
 * @date 2018年5月22日 上午9:29:54
 */
public class ReverseInteger {

  public int rever(int x) {

    long temp = 0;
    while (x != 0) {
      temp = temp * 10 + x % 10;
      x /= 10;
    }

    if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
      return 0;
    }

    return (int) temp;
  }

  public int reverse(int x) {
    int sign = x < 0 ? -1 : 1;
    StringBuilder sb = new StringBuilder((sign * x) + "");
    if (sb.charAt(0) == '-') {
      sb = sb.deleteCharAt(0);
    }

    sb = sb.reverse();

    while (sb.length() > 1 && sb.charAt(0) == '0') {
      sb = sb.deleteCharAt(0);
    }

    long num = Long.parseLong(sb.toString()) * sign;
    if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
      return 0;
    }
    return (int) num;
  }

}
