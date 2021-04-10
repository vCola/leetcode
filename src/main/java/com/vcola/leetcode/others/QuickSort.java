package com.vcola.leetcode.others;

import com.vcola.leetcode.utils.LeetUtil;

import java.util.Arrays;

public class QuickSort {

  public void quickSort(int[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  private void sort(int[] array, int low, int hi) {
    if (low >= hi) {
      return;
    }
    int j = partition(array, low, hi);
    sort(array, low, j - 1);
    sort(array, j + 1, hi);
  }

  private int partition(int[] array, int low, int hi) {
    int pivot = array[low];
    int i = low;
    int j = hi + 1;
    while (true) {
      // 找到左侧 大于 pivot的索引
      while (array[++i] <= pivot) {
        if (i == hi) {
          break;
        }
      }
      // 找到右侧 小于 pivot的索引
      while (array[--j] > pivot) {
        if (j == low) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      // 交换i, j后继续
      swap(array, i, j);
    }
    swap(array, low, j);
    return j;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    int loop = 5;
    for (int i = 0; i < loop; i++) {
      int[] nums = LeetUtil.randomArray(10);
      quickSort.quickSort(nums);
      System.out.println(Arrays.toString(nums));
      System.out.println(LeetUtil.isSorted(nums));
    }
  }

}
