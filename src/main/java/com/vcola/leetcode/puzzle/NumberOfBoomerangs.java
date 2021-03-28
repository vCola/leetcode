package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 *
 * @author Very Cola
 * @date 2018年11月19日 下午3:24:06
 */
public class NumberOfBoomerangs {

  public int numberOfBoomerangs(int[][] points) {
    int pointSize = points.length;
    double[][] distances = new double[pointSize][pointSize];

    double distance;
    for (int row = 0; row < pointSize; row++) {
      for (int col = 0; col < pointSize; col++) {
        distance = Math.sqrt(
            Math.pow(points[row][0] - points[col][0], 2) + Math.pow(points[row][1] - points[col][1], 2));
        distances[row][col] = distance;
        distances[col][row] = distance;
      }
    }

    int result = 0;
    Map<Double, Integer> countMap = new HashMap<>();
    for (int i = 0; i < pointSize; i++) {
      countMap.clear();
      double[] tempDistances = distances[i];
      for (int j = 0; j < pointSize; j++) {
        double tempDistance = tempDistances[j];
        Integer counter = countMap.get(tempDistance);
        if (counter == null) {
          counter = 1;
        } else {
          counter++;
        }
        countMap.put(tempDistance, counter);
      }

      for (Integer counter : countMap.values()) {
        if (counter > 1) {
          result += (counter * (counter - 1));
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
    NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
    System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
  }

}
