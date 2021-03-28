package com.vcola.leetcode.puzzle;

/**
 * 191. 位1的个数
 *
 * @author Very Cola
 * @date 2018年8月21日 上午9:00:12
 */
public class NumberOf1Bits {

  public int hammingWeight(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      if ((n >>> i & 1) == 1) {
        result++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new NumberOf1Bits().hammingWeight(127));
  }
}
