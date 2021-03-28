package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. 找不同
 *
 * @author Very Cola
 * @date 2018年10月30日 上午9:17:26
 */
public class FindTheDifference {

  public char findTheDifference(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : t.toCharArray()) {
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
      if (times == null) {
        return c;
      }

      times--;
      if (times == 0) {
        map.remove(c);
      } else {
        map.put(c, times);
      }
    }

    return map.keySet().iterator().next();
  }

  public static void main(String[] args) {

    FindTheDifference findTheDifference = new FindTheDifference();
    String s = "a";
    String t = "aa";

    System.out.println(findTheDifference.findTheDifference(s, t));

  }

}
