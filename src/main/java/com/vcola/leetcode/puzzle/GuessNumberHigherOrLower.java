package com.vcola.leetcode.puzzle;

/**
 * 374. 猜数字大小
 *
 * @author Very Cola
 * @date 2018年10月22日 上午10:28:34
 */
public class GuessNumberHigherOrLower {

  private int pick = 10;

  public int guessNumber(int n) {
    int low = 1, hi = n;
    while (true) {
      int result = (hi - low) / 2 + low;
      int comp = guess(result);
      if (comp == -1) {
        hi = result - 1;
      } else if (comp == 1) {
        low = result + 1;
      } else {
        return result;
      }
    }
  }

  public static void main(String[] args) {
    GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();
    System.out.println(guessNumberHigherOrLower.guessNumber(10));
  }

  // 搞反了 方向！！！
  private int guess(int result) {
    if (result > pick) {
      return -1;
    } else if (result < pick) {
      return 1;
    }
    return 0;
  }
}
