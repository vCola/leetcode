package com.vcola.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author Very Cola
 * @date 2018年9月19日 上午10:11:33
 */
public class IntersectionOfTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }

    Set<Integer> resultSet = new HashSet<>();
    for (int i = 0; i < nums2.length; i++) {
      if (set.contains(nums2[i])) {
        resultSet.add(nums2[i]);
      }
    }

    int[] result = new int[resultSet.size()];
    int index = 0;
    for (Integer num : resultSet) {
      result[index++] = num;
    }
    return result;
  }

}
