package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 401. 二进制手表
 *
 * @author Very Cola
 * @date 2018年11月5日 上午11:00:07
 */
public class BinaryWatch {

  public List<String> readBinaryWatch(int num) {
    List<String> result = new ArrayList<>();

    // init hours
    Map<Integer, List<String>> hourMap = new HashMap<>();
    for (int i = 0; i < 12; i++) {
      int ones = numsOfOne(i);
      List<String> list = hourMap.get(ones);
      if (list == null) {
        list = new ArrayList<>();
        hourMap.put(ones, list);
      }
      list.add("" + i);
    }

    // init mins
    Map<Integer, List<String>> minsMap = new HashMap<>();
    for (int i = 0; i < 60; i++) {
      int ones = numsOfOne(i);
      List<String> list = minsMap.get(ones);
      if (list == null) {
        list = new ArrayList<>();
        minsMap.put(ones, list);
      }
      if (i < 10) {
        list.add("0" + i);
      } else {
        list.add("" + i);
      }
    }

    int hourBits = 0;
    int minsBits = num - hourBits;
    while (num >= 0) {
      List<String> hours = hourMap.get(hourBits);
      List<String> mins = minsMap.get(minsBits);
      if (hours != null && !hours.isEmpty() && mins != null && !mins.isEmpty()) {
        for (String hour : hours) {
          for (String min : mins) {
            result.add(hour + ":" + min);
          }
        }
      }
      hourBits++;
      minsBits--;
      num--;
    }
    return result;
  }

  private int numsOfOne(int n) {
    int nums = 0;
    int moveBit = 6;
    while (moveBit-- > 0) {
      if ((n & 1) == 1) {
        nums++;
      }
      n >>= 1;
    }
    return nums;
  }

  public static void main(String[] args) {
    BinaryWatch binaryWatch = new BinaryWatch();
    System.out.println(binaryWatch.readBinaryWatch(1));
  }

}
