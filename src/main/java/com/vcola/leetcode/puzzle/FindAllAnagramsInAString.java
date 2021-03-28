package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author Very Cola
 * @date 2018年11月14日 下午4:10:47
 */
public class FindAllAnagramsInAString {

  // Brute
  public List<Integer> findAnagramsV1(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || "".equals(s)) {
      return result;
    }

    int index = 0;
    int lengthOfP = p.length();
    int resultMinusLength = s.length() - lengthOfP;

    char[] charArrayOfP = p.toCharArray();
    Arrays.sort(charArrayOfP);

    while (index <= resultMinusLength) {
      String subStr = s.substring(index, index + lengthOfP);
      if (isAnagramsEquals(charArrayOfP, subStr.toCharArray())) {
        result.add(index);
      }
      index++;
    }
    return result;
  }

  private boolean isAnagramsEquals(char[] sorted, char[] unsorted) {
    Arrays.sort(unsorted);
    return Objects.deepEquals(sorted, unsorted);
  }

  public List<Integer> findAnagramsV2(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || "".equals(s)) {
      return result;
    }

    Map<Character, Integer> countMap = new HashMap<>();
    char[] charArrayOfP = p.toCharArray();
    for (char c : charArrayOfP) {
      Integer count = countMap.get(c);
      if (count == null) {
        count = 1;
      } else {
        count++;
      }
      countMap.put(c, count);
    }

    int index = 0;
    int lengthOfP = p.length();
    int resultMinusLength = s.length() - lengthOfP;
    char c;
    Map<Character, Integer> tempMap = new HashMap<>();
    while (index <= resultMinusLength) {
      tempMap.clear();
      tempMap.putAll(countMap);

      int endIndex = index + lengthOfP - 1;
      for (int startIndex = index; startIndex <= endIndex; startIndex++) {
        c = s.charAt(startIndex);
        if (!countMap.containsKey(c)) {
          index = startIndex;
          break;
        }

        Integer count = tempMap.get(c);
        if (count == null) {
          break;
        } else if (count == 1) {
          if (startIndex == endIndex) {
            result.add(index);
          }
          tempMap.remove(c);
        } else {
          tempMap.put(c, --count);
        }
      }
      index++;
    }

    return result;
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || "".equals(s)) {
      return result;
    }

    int lengthOfS = s.length();
    int lengthOfP = p.length();
    if (lengthOfS < lengthOfP) {
      return result;
    }

    int resultMinusLength = lengthOfS - lengthOfP;
    for (int index = 0; index <= resultMinusLength; index++) {
      int[] tempArray = new int[26];
      for (int j = 0; j < lengthOfP; j++) {
        tempArray[s.charAt(index + j) - 'a']++;
        tempArray[p.charAt(j) - 'a']--;
      }

      boolean flag = true;
      for (int i = 0; i < tempArray.length; i++) {
        if (tempArray[i] != 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        result.add(index);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "abaccba";
    String p = "ab";

    FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
    System.out.println(obj.findAnagrams(s, p));
  }
}
