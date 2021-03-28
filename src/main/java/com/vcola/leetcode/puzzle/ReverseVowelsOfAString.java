package com.vcola.leetcode.puzzle;

import java.util.Arrays;
import java.util.List;

/**
 * 345. 反转字符串中的元音字母
 * A、E、I、O、U
 *
 * @author Very Cola
 * @date 2018年9月19日 上午9:50:12
 */
public class ReverseVowelsOfAString {

  public String reverseVowels(String s) {
    List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    char[] value = s.toCharArray();
    int lo = 0, hi = value.length - 1;
    while (hi > lo) {
      while (lo < value.length && !vowels.contains(value[lo])) {
        lo++;
      }
      while (hi >= 0 && !vowels.contains(value[hi])) {
        hi--;
      }

      if (lo < hi) {
        char temp = value[lo];
        value[lo] = value[hi];
        value[hi] = temp;
      }
      lo++;
      hi--;
    }
    return new String(value);
  }

  public static void main(String[] args) {
    String s = ",.";
    System.out.println(new ReverseVowelsOfAString().reverseVowels(s));
  }

}
