package com.vcola.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * @author Very Cola
 * @date 2018年8月22日 上午9:54:17
 */
public class HappyNumber {

  public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while (!set.contains(n)) {
      set.add(n);
      int temp = 0;
      while (n != 0) {
        int mode = n % 10;
        temp += (mode * mode);
        n /= 10;
      }
      if (temp == 1) {
        return true;
      }
      n = temp;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new HappyNumber().isHappy(5337410));
    HappyNumber happyNumber = new HappyNumber();
    for (int i = 1; i <= 10000; i++) {
      if (happyNumber.isHappy(i)) {
        System.out.println(i);
      }
    }
  }

}
