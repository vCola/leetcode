package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * 125. 验证回文串
 *
 * @author Very Cola
 * @date 2018年8月13日 上午9:49:58
 */
public class ValidPalindrome {

  public boolean isPalindrome(String s) {
    if (s == null || "".equals(s.trim())) {
      return true;
    }

    List<Character> chars = new ArrayList<>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        chars.add(c);
      } else if (c >= 'a' && c <= 'z') {
        chars.add(c);
      } else if (c >= 'A' && c <= 'Z') {
        chars.add((char) ('a' + (c - 'A')));
      }
    }

    length = chars.size();
    if (length == 0) {
      return true;
    }

    int mid = length / 2;
    for (int i = 0; i < mid; i++) {
      if (!chars.get(i).equals(chars.get(length - 1 - i))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "aba ";
    boolean result = new ValidPalindrome().isPalindrome(s);
    System.out.println(result);
  }

}
