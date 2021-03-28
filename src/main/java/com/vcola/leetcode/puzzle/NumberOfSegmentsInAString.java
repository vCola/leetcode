package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 434. 字符串中的单词数
 *
 * @author Very Cola
 * @date 2018年11月13日 上午10:09:30
 */
public class NumberOfSegmentsInAString {

  public int countSegments(String s) {
    int result = 0;
    if (s == null || s.trim().equals("")) {
      return result;
    }
    boolean isBlank = true;
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (c == ' ') {
        isBlank = true;
      } else if (isBlank) {
        isBlank = false;
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = " Hello, my name is John ";
    s = "    foo    bar    ";

    System.out.println(Arrays.toString(s.split(" ")));

    System.out.println(new NumberOfSegmentsInAString().countSegments(s));
  }

}
