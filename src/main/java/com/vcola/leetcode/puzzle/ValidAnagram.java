package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 *
 * @author Very Cola
 * @date 2018年9月6日 上午9:00:15
 */
public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] arrayS = s.toCharArray();
    char[] arrayT = t.toCharArray();

    // sort
    Arrays.sort(arrayS);
    Arrays.sort(arrayT);

    for (int i = 0; i < s.length(); i++) {
      if (arrayS[i] != arrayT[i]) {
        return false;
      }
    }

    return true;
  }

}
