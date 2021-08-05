package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_03 {

  public static int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    int low = 0, max = 1;
    char[] chars = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    map.put(chars[0], 0);
    for (int hi = 1; hi < s.length(); hi++) {
      if (map.containsKey(chars[hi])) {
        low = Math.max(map.get(chars[hi]) + 1, low);
      }
      map.put(chars[hi], hi);
      max = Math.max(max, hi - low + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "abba";
    System.out.println(lengthOfLongestSubstring(s));
  }

}
