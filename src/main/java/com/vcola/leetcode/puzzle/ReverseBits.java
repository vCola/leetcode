package com.vcola.leetcode.puzzle;

/**
 * 190. 颠倒二进制位
 *
 * @author Very Cola
 * @date 2018年8月20日 下午3:35:05
 */
public class ReverseBits {

  public int reverseBits(int n) {
    int result = 0;
    int bitIndex = 31;
    for (int i = 31; i >= 1; i -= 2) {
      result += ((n << i) & (1 << bitIndex--));
    }
    for (int i = 1; i <= 31; i += 2) {
      result += ((n >> i) & (1 << bitIndex--));
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new ReverseBits().reverseBits(43261596));
  }
}
