package com.vcola.leetcode.puzzle;

/**
 * 461. 汉明距离
 *
 * @author Very Cola
 * @date 2018年11月29日 下午1:52:54
 */
public class HammingDistance {

  public int hammingDistance(int x, int y) {
    int result = 0;
    while (x != 0 || y != 0) {
      if ((x & 1) != (y & 1)) {
        result++;
      }
      x >>>= 1;
      y >>>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    int x = -1;
    int y = 0;

    HammingDistance hammingDistance = new HammingDistance();
    System.out.println(hammingDistance.hammingDistance(x, y));
  }

}
