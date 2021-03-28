package com.vcola.leetcode.puzzle;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Very Cola
 * @date 2018年8月13日 上午9:35:32
 */
public class BestTimeToBuyAndSellStockII {

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
    for (int i = 0; i < length; i++) {
      if (difs[i] > 0) {
        result += difs[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] prices = { 1, 2, 3, 4, 5 };

    int result = new BestTimeToBuyAndSellStockII().maxProfit(prices);

    System.out.println(result);
  }

}
