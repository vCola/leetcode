package com.vcola.leetcode.puzzle;

/**
 * 415. 字符串相加
 *
 * @author Very Cola
 * @date 2018年11月9日 上午9:53:46
 */
public class AddStrings {

  public String addStrings(String num1, String num2) {
    String result = "";
    int index1 = num1.length() - 1;
    int index2 = num2.length() - 1;

    int rise = 0;
    int temp;
    char char1, char2;
    while (index1 >= 0 || index2 >= 0) {
      if (index1 >= 0) {
        char1 = num1.charAt(index1--);
      } else {
        char1 = '0';
      }

      if (index2 >= 0) {
        char2 = num2.charAt(index2--);
      } else {
        char2 = '0';
      }

      temp = (char1 - '0') + (char2 - '0') + rise;
      if (temp >= 10) {
        result = (temp % 10) + result;
        rise = 1;
      } else {
        result = temp + result;
        rise = 0;
      }
    }

    if (rise == 1) {
      result = "1" + result;
    }

    return result;
  }

  public static void main(String[] args) {
    String num1 = "10";
    String num2 = "5";

    AddStrings addStrings = new AddStrings();
    System.out.println(addStrings.addStrings(num1, num2));

  }

}
