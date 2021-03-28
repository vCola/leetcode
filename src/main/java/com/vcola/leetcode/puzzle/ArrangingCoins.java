package com.vcola.leetcode.puzzle;

/**
 * 441. 排列硬币
 *
 * @author Very Cola
 * @date 2018年11月15日 下午2:06:58
 */
public class ArrangingCoins {

  public int arrangeCoins(int n) {
    int lowRow = 1;
    int hiRow = 65535;
    int midRow = 0;
    long result;
    while (hiRow >= lowRow) {
      midRow = (hiRow - lowRow + 1) / 2 + lowRow;
      if (midRow % 2 == 0) {
        result = 1L * (midRow + 1) * (midRow / 2);
      } else {
        result = 1L * ((midRow + 1) / 2) * midRow;
      }

      if (result > n) {
        if (lowRow + 1 == hiRow) {
          midRow = lowRow;
          break;
        } else if (lowRow == hiRow) {
          midRow = lowRow - 1;
          break;
        }
        hiRow = midRow - 1;
      } else if (result < n) {
        lowRow = midRow + 1;
      } else {
        return midRow;
      }
    }

    result = (midRow + 1) * midRow / 2;
    if (result > n) {
      return midRow - 1;
    }

    return midRow;
  }

  public static void main(String[] args) {
    ArrangingCoins arrangingCoins = new ArrangingCoins();
    System.out.println(arrangingCoins.arrangeCoins(Integer.MAX_VALUE));

    System.out.println(Integer.MAX_VALUE);
  }
}
