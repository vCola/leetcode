package com.vcola.leetcode.puzzle;

/**
 * 28. 实现strStr()
 *
 * @author Very Cola
 * @date 2018年5月26日 上午7:51:32
 */
public class ImplementStrStr {

  public int strStr(String haystack, String needle) {
    if (haystack == null) {
      return -1;
    }

    if (needle == null) {
      return -1;
    }

    if ("".equals(needle)) {
      return 0;
    }

    int haystackLength = haystack.length();
    int needleLength = needle.length();

    if (needleLength > haystackLength) {
      return -1;
    }

    // 暴力查找
    int haystackIndex = 0;
    int needleIndex = 0;
    while (haystackIndex < haystackLength && needleIndex < needleLength) {
      if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
        haystackIndex++;
        needleIndex++;
      } else {
        haystackIndex = haystackIndex - needleIndex + 1;
        needleIndex = 0;
      }
    }

    if (needleIndex == needleLength) {
      return haystackIndex - needleLength;
    }

    return -1;
  }

  public static void main(String[] args) {

    ImplementStrStr strStr = new ImplementStrStr();

    String haystack = "hello";
    String needle = "lhell";

    System.out.println(strStr.strStr(haystack, needle));
  }

}
