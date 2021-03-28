package com.vcola.leetcode.puzzle;

/**
 * 459. 重复的子字符串
 *
 * @author Very Cola
 * @date 2018年11月29日 上午11:49:35
 */
public class RepeatedSubstringPattern {

  public boolean repeatedSubstringPattern(String s) {
    if (s == null || s.length() <= 1) {
      return false;
    }

    int length = s.length();
    for (int i = 1; i <= length / 2; i++) {
      if (length % i != 0) {
        continue;
      }

      for (int j = i; j < length; j++) {
        if (s.charAt(j) != s.charAt(j % i)) {
          break;
        }

        if (j + 1 == length) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    String s = "abcabc";
    RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));
  }

}
