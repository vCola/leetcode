package com.vcola.leetcode.puzzle;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author Very Cola
 * @date 2018年8月13日 上午9:35:32
 */
public class BestTimeToBuyAndSellStockII_122 {

  public int maxProfit(int[] prices) {
    int profit = 0;
    if (prices == null || prices.length == 0) {
      return profit;
    }
    int i = 0;
    for (int j = 1; j < prices.length; j++) {
      if (prices[j - 1] > prices[j]) {
        profit += prices[j - 1] - prices[i];
        i = j;
      } else if (j == prices.length - 1) {
        profit += prices[j] - prices[i];
      }
    }
    return profit;
  }

  public int maxProfitV1(int[] prices) {
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
    int[] prices = { 5, 4, 3 };
    int result = new BestTimeToBuyAndSellStockII_122().maxProfit(prices);
    System.out.println(result);
  }
}
