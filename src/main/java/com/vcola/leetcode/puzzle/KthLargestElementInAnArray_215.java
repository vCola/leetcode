package com.vcola.leetcode.puzzle;

import java.util.Random;

public class KthLargestElementInAnArray_215 {

  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quickSelect(int[] nums, int low, int hi, int index) {
    int p = randomPartition(nums, low, hi);
    while (p != index) {
      if (p < index) {
        low = p + 1;
      } else {
        hi = p - 1;
      }
      p = randomPartition(nums, low, hi);
    }
    return nums[p];
  }

  private int quickSelectV1(int[] nums, int low, int hi, int index) {
    int p = randomPartition(nums, low, hi);
    if (p == index) {
      return nums[p];
    }
    if (p < index) {
      return quickSelectV1(nums, p + 1, hi, index);
    }
    return quickSelectV1(nums, low, p - 1, index);
  }

  private int randomPartition(int[] nums, int low, int hi) {
    int randomIndex = low + new Random().nextInt(hi - low + 1);
    swap(nums, randomIndex, hi);
    return partition(nums, low, hi);
  }

  private int partition(int[] nums, int low, int hi) {
    int pivot = nums[hi];
    int i = low - 1;
    for (int j = low; j < hi; j++) {
      if (nums[j] <= pivot) {
        i++;
        swap(nums, i, j);
      }
    }
    swap(nums, i + 1, hi);
    return i + 1;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 2, 1, 5, 6, 4 };
    int k = 2;
    int val = new KthLargestElementInAnArray_215().findKthLargest(nums, k);
    System.out.println(val);
  }

}
