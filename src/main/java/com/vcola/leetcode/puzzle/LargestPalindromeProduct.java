package com.vcola.leetcode.puzzle;

/**
 * 479. 最大回文数乘积
 *
 * @author Very Cola
 * @date 2018年12月5日 下午5:10:31
 */
public class LargestPalindromeProduct {

  public int largestPalindromeV1(int n) {
    long maxNum = (long) Math.pow(10, n) - 1;
    long minNum = (long) Math.pow(10, n - 1);

    long value = 0, temp;

    for (long i = maxNum; i >= minNum; i--) {
      temp = i * i;
      if (temp <= value) {
        break;
      }
      for (long j = i; j >= minNum; j--) {
        temp = i * j;
        if (temp <= value) {
          break;
        }

        if (isPalindrome(temp + "")) {
          value = temp;
        }
      }
    }
    return (int) (value % 1337);
  }

  private boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public int largestPalindrome(int n) {
    long maxNum = (long) Math.pow(10, n) - 1;
    long minNum = (long) Math.pow(10, n - 1);

    long value = 0;
    for (long i = maxNum; i >= minNum; i--) {
      value = toPalindrome(i);
      for (long j = maxNum; j * j >= value; j--) {
        if (value % j == 0L) {
          return (int) (value % 1337);
        }
      }
    }

    return 9;
  }

  private long toPalindrome(long num) {
    long temp = num;
    while (temp != 0) {
      num = num * 10 + (temp % 10);
      temp /= 10;
    }
    return num;
  }

  public static void main(String[] args) {
    LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
    for (int n = 1; n <= 8; n++) {
      System.out.println(largestPalindromeProduct.largestPalindrome(n));
    }
  }

}
