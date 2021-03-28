package com.vcola.leetcode.puzzle;

/**
 * 400. 第N个数字
 *
 * @author Very Cola
 * @date 2018年10月30日 上午9:29:02
 */
public class NthDigit {

  public int findNthDigit(int n) {
    int bitWidth = 1;
    long bitTotal = 9L;
    if (n <= bitTotal) {
      return n;
    }

    while (n > bitTotal) {
      bitWidth++;
      bitTotal = bitTotal + 9 * (long) Math.pow(10, bitWidth - 1) * bitWidth;
    }

    bitTotal -= 9 * (long) Math.pow(10, bitWidth - 1) * bitWidth;

    int numsOfPreBitWidth = (int) Math.pow(10, bitWidth - 1) - 1;
    int num = (int) (numsOfPreBitWidth + ((n - bitTotal) / bitWidth));
    if ((n - bitTotal) % bitWidth != 0) {
      num = num + 1;
    }

    int index = (int) (n - bitTotal) % bitWidth;

    if (index == 0) {
      return num % 10;
    }
    num = num / (int) Math.pow(10, bitWidth - index);
    return num % 10;
  }

  public static void main(String[] args) {
    System.out.println(new NthDigit().findNthDigit(1000000000));
  }
}
