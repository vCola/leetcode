package com.vcola.leetcode.puzzle;

/**
 * 35. 搜索插入位置
 *
 * @author Very Cola
 * @date 2018年5月27日 下午12:59:22
 */
public class SearchInsertPosition_35 {

  public int searchInsert(int[] nums, int target) {
    int length = nums.length;
    int left = 0, right = length - 1, ans = length;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (target <= nums[mid]) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  public int searchInsertV1(int[] nums, int target) {
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

  public static void main(String[] args) {
    int[] nums = { 1, 3, 5, 6 };
    int idx = new SearchInsertPosition_35().searchInsert(nums, 2);
    System.out.println(idx);
  }

}
