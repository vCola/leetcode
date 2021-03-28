package com.vcola.leetcode.puzzle;

/**
 * 476. 数字的补数
 *
 * @author Very Cola
 * @date 2018年12月4日 下午2:51:40
 */
public class NumberComplement {

  public int findComplement(int num) {
    int result = 0;
    int bit = 0;
    while (num != 0) {
      result += ((1 & num ^ 1) * (1 << bit));
      bit++;
      num >>= 1;
    }
    return result;
  }

  public int findComplementV2(int num) {
    int ones = (Integer.highestOneBit(num) << 1) - 1;
    return num ^ ones;
  }

  public static void main(String[] args) {
    int num = 15;
    NumberComplement numberComplement = new NumberComplement();
    System.out.println(numberComplement.findComplement(num));
  }
}
