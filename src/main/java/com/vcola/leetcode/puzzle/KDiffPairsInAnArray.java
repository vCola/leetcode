package com.vcola.leetcode.puzzle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 532. 数组中的K-diff数对
 *
 * @author Very Cola
 * @date 2019年4月25日 上午10:14:18
 */
public class KDiffPairsInAnArray {

  public static void main(String[] args) {
    KDiffPairsInAnArray kDiffPairsInAnArray = new KDiffPairsInAnArray();
    int[] nums = { 1, 3, 1, 5, 1 };
    int k = 0;
    System.out.println(kDiffPairsInAnArray.findPairs(nums, k));
  }

  public int findPairs(int[] nums, int k) {
    if (k < 0) {
      return 0;
    }

    int result = 0;
    // 用于存放 数对中的买一个数
    Set<Integer> set = new HashSet<>();

    // 1 排序
    Arrays.sort(nums);

    // 2 遍历
    for (int i = 0, length = nums.length; i < length; i++) {
      int num = nums[i];
      if (set.contains(num)) {
        continue;
      }

      // 数组已经有序 直接找比num大的数
      int key = num - k;
      if (Arrays.binarySearch(nums, key) > -1) {
        if (key != num) {
          result++;
          set.add(num);
          set.add(key);
        } else if (i < length - 1 && nums[i + 1] == num) {
          result++;
          set.add(num);
        }
      }
    }

    return result;
  }

}
