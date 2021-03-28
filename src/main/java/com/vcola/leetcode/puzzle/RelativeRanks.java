package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 506. 相对名次
 *
 * @author Very Cola
 * @date 2019年4月6日 上午9:39:22
 */
public class RelativeRanks {

  public String[] findRelativeRanks(int[] nums) {
    int length = nums.length;
    String[] result = new String[length];
    // 1 sort
    int[] numsOrdered = new int[length];
    for (int i = 0; i < length; i++) {
      numsOrdered[i] = nums[i];
    }
    Arrays.sort(numsOrdered);

    // 2 binarySearch
    for (int i = 0; i < length; i++) {
      int rank = Arrays.binarySearch(numsOrdered, nums[i]);
      // 逆序
      rank = length - rank;
      if (rank == 1) {
        result[i] = "Gold Medal";
      } else if (rank == 2) {
        result[i] = "Silver Medal";
      } else if (rank == 3) {
        result[i] = "Bronze Medal";
      } else {
        result[i] = rank + "";
      }
    }
    return result;
  }

  public static void main(String[] args) {
    RelativeRanks relativeRanks = new RelativeRanks();
    int[] nums = { 5, 4, 3, 2, 1 };
    System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(nums)));
  }

}
