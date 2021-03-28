package com.vcola.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author Very Cola
 * @date 2018年8月24日 上午9:15:05
 */
public class ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    return false;
  }
}
