package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * @author Very Cola
 * @date 2018年8月23日 上午10:38:47
 */
public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s == null && t != null) {
      return false;
    }
    if (t == null && s != null) {
      return false;
    }
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Character> mapS = new HashMap<>();
    Map<Character, Character> mapT = new HashMap<>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      Character charS = s.charAt(i);
      Character charT = t.charAt(i);

      if (mapS.get(charS) == null) {
        mapS.put(charS, charT);
      } else if (!charT.equals(mapS.get(charS))) {
        return false;
      }

      if (mapT.get(charT) == null) {
        mapT.put(charT, charS);
      } else if (!charS.equals(mapT.get(charT))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "egg";
    String t = "acc";

    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
    System.out.println(isomorphicStrings.isIsomorphic(s, t));
  }

}
