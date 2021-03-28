package com.vcola.leetcode.puzzle;

/**
 * 171. Excel表列序号
 *
 * @author Very Cola
 * @date 2018年8月17日 上午10:13:05
 */
public class ExcelSheetColumnNumber {

  public int titleToNumber(String s) {
    int result = 0;
    int length = s.length();
    for (int i = 0; i < length; i++) {
      int temp = (int) Math.pow(26, length - i - 1);
      temp = temp * (s.charAt(i) - 'A' + 1);
      result += temp;
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "AAT";
    System.out.println(new ExcelSheetColumnNumber().titleToNumber(s));
  }

}
