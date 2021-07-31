package com.vcola.leetcode.others;

public class Sqrt {

  public static int sqrt (int x) {
    if (x <= 0) {
      return 0;
    }
    int low = 1, hi = x, mid;
    while (true) {
      mid = low + (hi - low) / 2;
      if (mid > x / mid) {
        hi = mid - 1;
      } else {
        if ((mid + 1) > x / (mid + 1)) {
          return mid;
        }
        low = mid + 1;
      }
    }
  }
}
