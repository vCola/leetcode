package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author Very Cola
 * @date 2018年10月30日 上午9:06:34
 */
public class FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    if (s == null) {
      return -1;
    }

    int result = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      Integer times = map.get(c);
      if (times == null) {
        times = 1;
      } else {
        times++;
      }
      map.put(c, times);
    }

    for (Character c : s.toCharArray()) {
      Integer times = map.get(c);
      if (times == 1) {
        return result;
      }
      result++;
    }

    return -1;
  }

}
