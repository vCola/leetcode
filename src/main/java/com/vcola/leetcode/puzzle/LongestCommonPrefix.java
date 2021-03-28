package com.vcola.leetcode.puzzle;

/**
 * 14. 最长公共前缀
 *
 * @author Very Cola
 * @date 2018年5月24日 上午8:41:16
 */
public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    String result = "";

    if (strs == null || strs.length == 0) {
      return result;
    }

    boolean end = false;
    int index = 0;
    while (!end) {
      if (index >= strs[0].length()) {
        break;
      }
      char c = strs[0].charAt(index);
      for (int i = 1; i < strs.length; i++) {
        if (index >= strs[i].length() || strs[i].charAt(index) != c) {
          end = true;
          break;
        }
      }

      if (!end) {
        result += c;
        index++;
      }

    }

    return result;
  }

  public static void main(String[] args) {

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String maxPrefix = longestCommonPrefix.longestCommonPrefix(new String[] { "aa", "a" });

    System.out.println(maxPrefix);

  }

}
