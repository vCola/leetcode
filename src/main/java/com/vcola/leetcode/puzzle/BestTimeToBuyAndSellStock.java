package com.vcola.leetcode.puzzle;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author Very Cola
 * @date 2018年8月9日 上午10:02:31
 */
public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    int length = 0;
    if (prices == null || (length = prices.length) == 0) {
      return 0;
    }

    int[] difs = new int[length];
    for (int i = 1; i < length; i++) {
      difs[i] = prices[i] - prices[i - 1];
    }

    int result = 0;
    int temp = 0;
    for (int i = 0; i < length; i++) {
      temp += difs[i];
      if (temp < 0) {
        temp = 0;
      } else if (temp > result) {
        result = temp;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] prices = { 7, 6, 4, 3, 1 };

    int result = new BestTimeToBuyAndSellStock().maxProfit(prices);

    System.out.println(result);
  }

}
