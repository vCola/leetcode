package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. 键盘行
 *
 * @author Very Cola
 * @date 2018年12月14日 上午10:55:15
 */
public class KeyboardRow {

  static Map<Character, Integer> map = new HashMap<>();

  static {
    char[] row01 = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
    char[] row02 = { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
    char[] row03 = { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };

    for (char c : row01) {
      map.put(c, 1);
      map.put((char) (c - 'a' + 'A'), 1);
    }

    for (char c : row02) {
      map.put(c, 2);
      map.put((char) (c - 'a' + 'A'), 2);
    }

    for (char c : row03) {
      map.put(c, 3);
      map.put((char) (c - 'a' + 'A'), 3);
    }
  }

  public String[] findWords(String[] words) {
    List<String> list = new ArrayList<>();

    char[] tempArray;
    boolean yes;
    for (String word : words) {
      yes = true;
      tempArray = word.toCharArray();
      Integer v = map.get(tempArray[0]);
      for (int i = 1; i < word.length(); i++) {
        if (!map.get(tempArray[i]).equals(v)) {
          yes = false;
          break;
        }
      }

      if (yes) {
        list.add(word);
      }
    }
    return list.toArray(new String[] {});
  }

  public static void main(String[] args) {
    String[] words = { "Hello", "Alaska", "Dad", "Peace" };
    KeyboardRow keyboardRow = new KeyboardRow();
    System.out.println(Arrays.toString(keyboardRow.findWords(words)));
  }
}
