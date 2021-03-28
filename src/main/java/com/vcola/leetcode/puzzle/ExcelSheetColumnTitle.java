package com.vcola.leetcode.puzzle;

/**
 * 168. Excel表列名称
 *
 * @author Very Cola
 * @date 2018年8月17日 上午9:01:41
 */
public class ExcelSheetColumnTitle {

  // 26进制 A - Z
  public String convertToTitle(int n) {
    if (n <= 0) {
      return null;
    }

    String result = "";
    while (n > 0) {
      int temp = n % 26;
      char c;
      if (temp == 0) {
        c = 'Z';
      } else {
        c = (char) ('A' + temp - 1);
      }
      result = c + result;
      if (n % 26 == 0) {
        n = n / 26 - 1;
      } else {
        n = n / 26;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new ExcelSheetColumnTitle().convertToTitle(676));
  }

}
