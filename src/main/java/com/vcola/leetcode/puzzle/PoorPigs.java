package com.vcola.leetcode.puzzle;

/**
 * 458. 可怜的小猪
 *
 * @author Very Cola
 * @date 2018年11月27日 下午1:39:56
 */
public class PoorPigs {

  /**
   * @param buckets
   * @param minutesToDie
   * @param minutesToTest
   * @return
   */
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int result = 0;
    if (buckets == 0) {
      return result;
    }

    int maxBucketPerPig = minutesToTest / minutesToDie + 1;
    while (Math.pow(maxBucketPerPig, result) < buckets) {
      result++;
    }
    return result;
  }

  public static void main(String[] args) {
    int buckets = 2;
    int minutesToDie = 15;
    int minutesToTest = 60;

    PoorPigs poorPigs = new PoorPigs();
    System.out.println(poorPigs.poorPigs(buckets, minutesToDie, minutesToTest));
  }

}
