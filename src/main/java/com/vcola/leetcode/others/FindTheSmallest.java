package com.vcola.leetcode.others;

public class FindTheSmallest {

  public static int findTheSmall(int[] nums) {
    int length = nums.length;
    int low = 0, hi = length - 1;
    int mid, left, right;
    while (low < hi) {
      mid = low + (hi - low) / 2;
      left = mid - 1;
      while (left >= low) {
        if (nums[left] > nums[mid]) {
          break;
        }
        if (nums[left] < nums[mid]) {
          hi = left;
          break;
        }
        left--;
      }
      right = mid + 1;
      while (right <= hi) {
        if (nums[right] > nums[mid]) {
          break;
        }
        if (nums[right] < nums[mid]) {
          low = right;
          break;
        }
        right++;
      }
      if (left < low && right > hi) {
        return nums[mid];
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] nums = {9, 8, 7, 7, 7, -10, 4, 8, 10};
    int smallest = findTheSmall(nums);
    System.out.println(smallest);
  }

}
