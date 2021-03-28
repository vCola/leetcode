package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @author Very Cola
 * @date 2018年6月6日 上午9:14:29
 */
public class MergeSortedArray {

  /**
   * 倒序处理
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void mergeReverse(int[] nums1, int m, int[] nums2, int n) {

  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // index
    int index = 0;
    int index1 = 0;
    int index2 = 0;

    // temp
    int temp1 = m < 1 ? Integer.MAX_VALUE : nums1[index1];
    int temp2 = n < 1 ? Integer.MAX_VALUE : nums2[index2];

    while (index < m + n) {
      if (temp1 > temp2) {
        // >>>
        for (int i = m + n - 1; i > index; i--) {
          nums1[i] = nums1[i - 1];
        }
        nums1[index] = temp2;
        temp2 = ++index2 >= n ? Integer.MAX_VALUE : nums2[index2];
      } else {
        temp1 = ++index1 >= m ? Integer.MAX_VALUE : nums1[index + 1];
      }
      index++;
    }
  }

  public static void main(String[] args) {
    MergeSortedArray mergeSortedArray = new MergeSortedArray();
    int[] nums1 = { 4, 5, 6, 0, 0, 0 };
    int m = 3;
    int[] nums2 = { 1, 7, 33 };
    int n = 3;

    mergeSortedArray.merge(nums1, m, nums2, n);

    System.out.println(Arrays.toString(nums1));
  }

}
