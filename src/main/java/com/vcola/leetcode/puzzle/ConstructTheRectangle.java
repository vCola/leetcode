package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 492. 构造矩形
 *
 * @author Very Cola
 * @date 2018年12月13日 上午10:10:41
 */
public class ConstructTheRectangle {

  public int[] constructRectangle(int area) {
    int[] result = new int[2];
    int sqrt = (int) Math.ceil(Math.sqrt(area));
    while (area % sqrt != 0) {
      sqrt--;
    }

    if (area / sqrt > sqrt) {
      result[0] = area / sqrt;
      result[1] = sqrt;
    } else {
      result[0] = sqrt;
      result[1] = area / sqrt;
    }
    return result;
  }

  public static void main(String[] args) {
    int area = 2;
    ConstructTheRectangle constructTheRectangle = new ConstructTheRectangle();
    System.out.println(Arrays.toString(constructTheRectangle.constructRectangle(area)));
  }

}
