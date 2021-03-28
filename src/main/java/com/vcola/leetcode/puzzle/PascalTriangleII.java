package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * @author Very Cola
 * @date 2018年8月8日 上午9:53:13
 */
public class PascalTriangleII {

  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>(rowIndex + 1);
    for (int i = 0; i <= rowIndex; i++) {
      result.add(1);
      for (int j = i - 1; j >= 1; j--) {
        result.set(j, result.get(j) + result.get(j - 1));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new PascalTriangleII().getRow(33));
  }

}
