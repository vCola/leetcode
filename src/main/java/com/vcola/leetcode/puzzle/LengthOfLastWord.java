package com.vcola.leetcode.puzzle;

/**
 * 58. 最后一个单词的长度
 *
 * @author Very Cola
 * @date 2018年5月30日 上午8:58:12
 */
public class LengthOfLastWord {

  public int lengthOfLastWord(String s) {
    if (s == null || "".equals(s)) {
      return 0;
    }

    int result = 0;
    int index = s.length() - 1;
    while (index >= 0) {
      if (s.charAt(index) == ' ') {
        if (result == 0) {
          index--;
          continue;
        }
        return result;
      }
      result++;
      index--;
    }

    return result;
  }

  public static void main(String[] args) {
    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

    String s = "Hello  World ";
    System.out.println(lengthOfLastWord.lengthOfLastWord(s));

  }

}
