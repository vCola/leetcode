package com.vcola.leetcode.puzzle;

/**
 * 9. 回文数
 *
 * @author Very Cola
 * @date 2018年5月23日 上午9:11:36
 */
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    String str = x + "";
    for (int left = 0, right = str.length() - 1; left < right; left++, right--) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    PalindromeNumber isPalindrome = new PalindromeNumber();
    System.out.println(isPalindrome.isPalindrome(1010101));

  }

}
