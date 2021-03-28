package com.vcola.leetcode.puzzle;

/**
 * 35. 搜索插入位置
 *
 * @author Very Cola
 * @date 2018年5月27日 下午12:59:22
 */
public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    int length = nums.length;
    if (length == 0) {
      return 0;
    }

    int left = 0;
    int right = length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        return mid;
      }
    }

    return left;
  }

  /**
   * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引
   * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
   *
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert001(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        if (left == right) {
          return left + 1;
        }

        left = mid + 1;
      } else if (nums[mid] > target) {
        if (left == right) {
          return right;
        }

        right = mid - 1;
        if (right < left) {
          return mid;
        }
      } else {
        return mid;
      }
    }

    return 0;
  }

}
