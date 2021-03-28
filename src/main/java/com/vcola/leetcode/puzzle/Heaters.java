package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 475. 供暖器
 *
 * @author Very Cola
 * @date 2018年11月29日 下午2:59:43
 */
public class Heaters {

  /*
   * 问题一步一步分解
   * 	思路：
   * 		找出距离每个房子最近的供暖器位置
   *  求以上位置距离的最大
   */
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int heaterSize = heaters.length;
    int result = 0;
    int heaterIndex = 0;

    for (int house : houses) {
      while (heaterIndex < heaterSize - 1 && Math.abs(heaters[heaterIndex] - house) >= Math.abs(
          heaters[heaterIndex + 1] - house)) {
        heaterIndex++;
      }
      result = Math.max(result, Math.abs(heaters[heaterIndex] - house));
    }
    return result;
  }

}
