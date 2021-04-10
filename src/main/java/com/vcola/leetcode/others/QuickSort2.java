package com.vcola.leetcode.others;

import com.vcola.leetcode.utils.LeetUtil;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

  public void quickSort(int[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  private void sort(int[] nums, int low, int hi) {
    if (low >= hi) {
      return;
    }

    int p = randomPartition(nums, low, hi);
    sort(nums, low, p - 1);
    sort(nums, p + 1, hi);
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
    QuickSort2 quickSort2 = new QuickSort2();
    int loop = 5;
    for (int i = 0; i < loop; i++) {
      int[] nums = LeetUtil.randomArray(10);
      quickSort2.quickSort(nums);
      System.out.println(Arrays.toString(nums));
      System.out.println(LeetUtil.isSorted(nums));
    }
  }
}
