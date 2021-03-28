package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * @author Very Cola
 * @date 2018年9月28日 下午1:47:05
 */
public class IntersectionOfTwoArraysII {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
    }

    List<Integer> list = new ArrayList<>();
    for (int num : nums2) {
      if (map.get(num) != null && map.get(num) > 0) {
        list.add(num);
        map.put(num, map.get(num) - 1);
      }
    }

    int[] result = new int[list.size()];
    int index = 0;
    for (Integer num : list) {
      result[index++] = num;
    }
    return result;
  }

}
