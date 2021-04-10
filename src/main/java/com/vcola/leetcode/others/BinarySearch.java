package com.vcola.leetcode.others;

public class BinarySearch {

  public int searchNonRecursive(int[] nums, int target) {
    int low = 0;
    int hi = nums.length - 1;
    int mid;
    while (low <= hi) {
      mid = low + (hi - low) / 2;
      if (nums[mid] > target) {
        hi = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length - 1);
  }

  private int search(int[] nums, int target, int low, int hi) {
    if (low > hi) {
      return -1;
    }
    int mid = low + (hi - low) / 2;
    if (nums[mid] > target) {
      return search(nums, target, low, mid - 1);
    } else if (nums[mid] < target) {
      return search(nums, target, mid + 1, hi);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int targetIndex = new BinarySearch().searchNonRecursive(nums, 1);
    System.out.println(targetIndex);
  }

}
