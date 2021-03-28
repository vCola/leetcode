package com.vcola.leetcode.puzzle;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * @author Very Cola
 * @date 2018年9月28日 下午2:28:00
 */
public class SumOfTwoIntegers {

  public int getSum(int a, int b) {
    String binA = Integer.toBinaryString(a);
    String binB = Integer.toBinaryString(b);

    String binS = "";
    int indexA = binA.length() - 1;
    int indexB = binB.length() - 1;
    int rise = 0;
    while (binS.length() < 32 && (indexA >= 0 || indexB >= 0)) {
      char charA = indexA >= 0 ? binA.charAt(indexA) : '0';
      char charB = indexB >= 0 ? binB.charAt(indexB) : '0';
      // 字符相等
      if (charA == charB) {
        if (charA == '1') {
          binS = rise + binS;
          rise = 1;
        } else {
          binS = rise + binS;
          rise = 0;
        }
      } else {
        if (rise == 1) {
          binS = 0 + binS;
          rise = 1;
        } else {
          binS = 1 + binS;
          rise = 0;
        }
      }
      indexA--;
      indexB--;
    }
    if (binS.length() < 32) {
      binS = rise + binS;
    }
    return Integer.parseUnsignedInt(binS, 2);
  }

  public static void main(String[] args) {
    SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
    System.out.println(sumOfTwoIntegers.getSum(-1, 1));
  }

}
