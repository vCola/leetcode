package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 455. 分发饼干
 *
 * @author Very Cola
 * @date 2018年11月27日 上午11:49:39
 */
public class AssignCookies {

  public int findContentChildren(int[] g, int[] s) {
    int result = 0;
    Arrays.sort(g);
    Arrays.sort(s);
    int childSize = g.length;
    int cookieSize = s.length;

    int clildGreed, cookieContent;
    int cookieIndex = 0;
    for (int i = 0; i < childSize; i++) {
      if (cookieIndex >= cookieSize) {
        break;
      }

      clildGreed = g[i];
      while (cookieIndex < cookieSize) {
        cookieContent = s[cookieIndex++];
        if (cookieContent >= clildGreed) {
          result++;
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] g = { 1, 2, 3, 1 };
    int[] s = { 1, 1, 3 };

    AssignCookies assignCookies = new AssignCookies();
    System.out.println(assignCookies.findContentChildren(g, s));
  }

}
