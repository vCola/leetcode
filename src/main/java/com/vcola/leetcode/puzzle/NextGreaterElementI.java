package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 *
 * @author Very Cola
 * @date 2018年12月14日 上午9:54:12
 */
public class NextGreaterElementI {

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int length = nums1.length;
    int[] result = new int[length];
    int tempI, tempJ;
    boolean start = false, exists = false;
    for (int i = 0; i < length; i++) {
      start = false;
      exists = false;
      tempI = nums1[i];
      for (int j = 0; j < nums2.length; j++) {
        tempJ = nums2[j];
        if (tempI == tempJ) {
          start = true;
        }

        if (start && tempJ > tempI) {
          exists = true;
          result[i] = tempJ;
          break;
        }
      }

      if (!exists) {
        result[i] = -1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
    int[] nums1 = { 2, 4 };
    int[] nums2 = { 1, 2, 3, 4 };
    System.out.println(Arrays.toString(nextGreaterElementI.nextGreaterElement(nums1, nums2)));

  }

}
