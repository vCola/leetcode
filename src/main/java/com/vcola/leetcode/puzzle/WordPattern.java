package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词模式
 *
 * @author Very Cola
 * @date 2018年9月13日 上午10:21:39
 */
public class WordPattern {

  public boolean wordPattern(String pattern, String str) {
    String[] strs = str.split(" ");

    if (pattern.length() != strs.length) {
      return false;
    }

    Map<Character, String> patternStrMap = new HashMap<>();
    Map<String, Character> strPatternMap = new HashMap<>();

    for (int i = 0; i < pattern.length(); i++) {
      Character c = pattern.charAt(i);
      String s = strs[i];

      if (patternStrMap.get(c) != null) {
        if (!patternStrMap.get(c).equals(s)) {
          return false;
        }
      } else {
        patternStrMap.put(c, s);
      }

      if (strPatternMap.get(s) != null) {
        if (!strPatternMap.get(s).equals(c)) {
          return false;
        }
      } else {
        strPatternMap.put(s, c);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String pattern = "aaaa";
    String str = "dog dog dog dog";
    System.out.println(new WordPattern().wordPattern(pattern, str));
  }

}
