package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @author Very Cola
 * @date 2018年11月23日 下午4:32:04
 */
public class FindAllNumbersDisappearedInAnArray {

  /*
   * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
   *	找到所有在 [1, n] 范围之间没有出现在数组中的数字。
   *	您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
   * input:  [4,3,2,7,8,2,3,1]
   * output: [5,6]
   */

  // 不符合O(n)
  public List<Integer> findDisappearedNumbersV1(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int length = nums.length;
    for (int i = 1; i <= length; i++) {
      result.add(i);
    }

    for (Integer num : nums) {
      result.remove(num);
    }

    return result;
  }

  // 不符合O(n)
  public List<Integer> findDisappearedNumbersV2(int[] nums) {
    List<Integer> result = new ArrayList<>();
    boolean[] flags = new boolean[nums.length + 1];
    for (int num : nums) {
      flags[num] = true;
    }

    int length = flags.length;
    for (int i = 1; i < length; i++) {
      if (!flags[i]) {
        result.add(i);
      }
    }
    return result;
  }

  // O(n)
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> result = new ArrayList<>();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      // 索引
      int index = Math.abs(nums[i]) - 1;

      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }

    for (int i = 0; i < length; i++) {
      if (nums[i] > 0) {
        result.add(i + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
    FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
    System.out.println(findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums));
  }

}
