package com.vcola.leetcode.puzzle;

public class LongestPalindromicSubstring_5 {

  public static String longestPalindrome(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      String s1 = palindrome(s, i, i);
      String s2 = palindrome(s, i, i + 1);
      result = result.length() < s1.length() ? s1 : result;
      result = result.length() < s2.length() ? s2 : result;
    }
    return result;
  }

  private static String palindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) {
        break;
      }
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }

  // manacher alg
  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindrome(s));
  }

}
