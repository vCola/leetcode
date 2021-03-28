package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 *
 * @author Very Cola
 * @date 2018年10月22日 上午10:28:46
 */
public class RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {
    if (magazine == null) {
      return ransomNote == null;
    }

    Map<Character, Integer> map = new HashMap<>();
    char[] chars = magazine.toCharArray();
    for (char c : chars) {
      Integer sum = map.get(c);
      if (sum == null) {
        sum = 1;
      } else {
        sum += 1;
      }
      map.put(c, sum);
    }

    chars = ransomNote.toCharArray();
    for (char c : chars) {
      Integer sum = map.get(c);
      if (sum == null) {
        return false;
      }
      sum = sum - 1;
      if (sum == 0) {
        map.remove(c);
      } else {
        map.put(c, sum);
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String ransomNote = "aa";
    String magazine = "ab";

    System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

  }

}
