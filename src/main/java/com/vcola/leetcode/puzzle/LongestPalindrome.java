package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 409. 最长回文串
 *
 * @author Very Cola
 * @date 2018年11月7日 下午5:31:28
 */
public class LongestPalindrome {

  public static void main(String[] args) {
    String s = "abccccdd";
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    System.out.println(longestPalindrome.longestPalindrome(s));
  }

  public int longestPalindrome(String s) {
    int result = 0;
    if (s == null || s.trim().equals("")) {
      return result;
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      Integer freq = map.get(c);
      if (freq == null) {
        freq = 0;
      }
      freq++;
      map.put(c, freq);
    }
    boolean addOne = false;
    for (Integer freq : map.values()) {
      if (freq % 2 == 0) {
        result += freq;
      } else {
        addOne = true;
        result += freq - 1;
      }
    }
    if (addOne) {
      result++;
    }
    return result;
  }

  public int longestPalindromeV1(String s) {
    int result = 0;
    if (s == null || s.trim().equals("")) {
      return result;
    }

    Map<Character, CharCount> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      CharCount charCount = map.get(c);
      if (charCount == null) {
        charCount = new CharCount();
        charCount.cha = c;
        map.put(c, charCount);
      }
      charCount.increFreq();
    }

    PriorityQueue<CharCount> priorityQueue = new PriorityQueue<>();
    priorityQueue.addAll(map.values());

    while (!priorityQueue.isEmpty()) {
      CharCount charCount = priorityQueue.remove();
      int freq = charCount.freq;
      if (freq == 1) {
        return result + 1;
      }

      if (freq % 2 == 0) {
        result += freq;
      } else {
        result += freq - 1;
        charCount.freq = 1;
        priorityQueue.add(charCount);
      }
    }

    return result;
  }

  public static class CharCount implements Comparable<CharCount> {

    private Character cha;
    private int freq;

    @Override
    public int compareTo(CharCount o) {
      return o.freq - this.freq;
    }

    @Override
    public String toString() {
      return "CharCount [cha=" + cha + ", freq=" + freq + "]";
    }

    public void decreFreq(int decre) {
      this.freq -= decre;
    }

    public void increFreq() {
      this.freq++;
    }
  }

}
