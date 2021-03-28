package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * @author Very Cola
 * @date 2018年5月23日 上午9:15:52
 */
public class RomanToInteger {

  /**
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   */
  public int romanToInt(String s) {

    Map<Character, Integer> dict = new HashMap<>();
    dict.put('I', 1);
    dict.put('V', 5);
    dict.put('X', 10);
    dict.put('L', 50);
    dict.put('C', 100);
    dict.put('D', 500);
    dict.put('M', 1000);

    int result = 0;
    int index = 0;
    while (index < s.length()) {
      if (index < s.length() - 1 && dict.get(s.charAt(index)) < dict.get(s.charAt(index + 1))) {
        result += dict.get(s.charAt(index + 1)) - dict.get(s.charAt(index));
        index += 2;
      } else {
        result += dict.get(s.charAt(index));
        index++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    RomanToInteger romanToInt = new RomanToInteger();
    System.out.println(romanToInt.romanToInt("III"));
  }

}
