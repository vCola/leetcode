package com.vcola.leetcode.puzzle;

/**
 * 258. 各位相加
 *
 * @author Very Cola
 * @date 2018年9月7日 上午9:29:15
 */
public class AddDigits {

  public int addDigits(int num) {
    while (num >= 10) {
      int temp = 0;
      while (num > 0) {
        temp += (num % 10);
        num /= 10;
      }
      num = temp;
    }
    return num;
  }

  // T -> O(1)
  public int addDigits02(int num) {
    // TODO

    return 0;
  }

  public static void main(String[] args) {
    AddDigits addDigits = new AddDigits();
    System.out.println(addDigits.addDigits(945665));
  }

}
