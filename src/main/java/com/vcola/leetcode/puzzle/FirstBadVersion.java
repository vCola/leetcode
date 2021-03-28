package com.vcola.leetcode.puzzle;

/**
 * 278. 第一个错误的版本
 *
 * @author Very Cola
 * @date 2018年9月12日 上午11:06:37
 */
public class FirstBadVersion {

  // 这是个 二分查找
  public int firstBadVersion(int n) {
    return firstBadVersion(1, n);
  }

  private int firstBadVersion(int lo, int hi) {
    if (lo > hi) {
      return hi + 1;
    }
    int mid = lo + (hi - lo) / 2;

    if (isBadVersion(mid)) {
      return firstBadVersion(lo, mid - 1);
    } else {
      return firstBadVersion(mid + 1, hi);
    }
  }

  private boolean[] badFlag = { false, false, false, false, true };

  private boolean isBadVersion(int version) {
    return badFlag[version - 1];
  }

}
