package com.vcola.leetcode.puzzle;

/**
 * 344. 反转字符串
 *
 * @author Very Cola
 * @date 2018年9月19日 上午9:43:53
 */
public class ReverseString {

  public String reverseString(String s) {
    char[] value = s.toCharArray();
    for (int low = 0, hi = value.length - 1; hi > low; low++, hi--) {
      char temp = value[low];
      value[low] = value[hi];
      value[hi] = temp;
    }
    return new String(value);
  }

  public static void main(String[] args) {
    String s = "a";
    System.out.println(new ReverseString().reverseString(s));
  }

}
