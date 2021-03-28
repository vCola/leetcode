package com.vcola.leetcode.puzzle;

/**
 * 405. 数字转换为十六进制数
 *
 * @author Very Cola
 * @date 2018年11月7日 下午5:13:10
 */
public class ConvertANumberToHexadecimal {

  public String toHex(int num) {
    String[] symbols = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    if (num == 0) {
      return symbols[0];
    }

    String result = "";
    int mask = (1 << 4) - 1;
    int bitShiftTimes = 8;
    while (bitShiftTimes-- > 0) {
      if (num == 0) {
        break;
      }
      result = symbols[num & mask] + result;
      num >>= 4;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new ConvertANumberToHexadecimal().toHex(Integer.MAX_VALUE));
    System.out.println(new ConvertANumberToHexadecimal().toHex(Integer.MIN_VALUE));
    System.out.println(new ConvertANumberToHexadecimal().toHex(0));
  }

}
