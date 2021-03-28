package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 组合 C0 -> Cn
 *
 * @author Very Cola
 * @date 2018年7月27日 上午9:55:53
 */
public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>(numRows);
    if (numRows <= 0) {
      return result;
    }

    if (numRows >= 1) {
      result.add(Arrays.asList(1));
    }

    if (numRows >= 2) {
      result.add(Arrays.asList(1, 1));
    }

    // >= 3
    for (int row = 3; row <= numRows; row++) {
      List<Integer> list = new ArrayList<>(row);
      List<Integer> preList = result.get(row - 2);
      for (int i = 0; i < row; i++) {
        if (i == 0 || i == row - 1) {
          list.add(1);
        } else {
          list.add(preList.get(i - 1) + preList.get(i));
        }
      }
      result.add(list);
    }
    return result;
  }

  public static void main(String[] args) {

    List<List<Integer>> result = new PascalTriangle().generate(10);

    result.forEach(list -> {
      System.out.println(list);
    });

  }

}
