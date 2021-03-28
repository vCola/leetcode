package com.vcola.leetcode.puzzle;

/**
 * 38. 报数
 *
 * @author Very Cola
 * @date 2018年5月28日 上午9:07:28
 */
public class CountAndSay {

  public String countAndSay(int n) {
    String result = "1";

    for (int i = 1; i < n; i++) {
      String temp = "";
      int length = result.length();
      char c = result.charAt(0);
      int count = 0;

      int j = 0;
      while (j < length) {
        char nextChar = result.charAt(j);
        if (c == nextChar) {
          count++;
          if (j == length - 1) {
            temp += "" + count + c;
          }
          j++;
        } else {
          temp += "" + count + c;
          count = 0;
          c = nextChar;
        }
      }

      result = temp;
    }

    return result;
  }

  public static void main(String[] args) {

    CountAndSay countAndSay = new CountAndSay();
    System.out.println(countAndSay.countAndSay(8));

    // 13112221

  }

}
