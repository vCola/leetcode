package com.vcola.leetcode.puzzle;

/**
 * 504. 七进制数
 *
 * @author Very Cola
 * @date 2019年4月6日 上午9:25:24
 */
public class Base7 {

  public String convertToBase7(int num) {
    // == 0
    if (num == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    // > =
    if (num > 0) {
      while (num != 0) {
        sb.insert(0, num % 7 + "");
        num = num / 7;
      }
      return sb.toString();
    }

    // < 0
    num = -num;
    while (num != 0) {
      sb.insert(0, num % 7 + "");
      num = num / 7;
    }
    sb.insert(0, "-");
    return sb.toString();
  }

  public static void main(String[] args) {
    Base7 base7 = new Base7();
    System.out.println(base7.convertToBase7(-7));
  }

}
