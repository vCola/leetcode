package com.vcola.leetcode.puzzle;

import java.util.Objects;

/**
 * 521. 最长特殊序列 Ⅰ
 *
 * @author Very Cola
 * @date 2019年4月15日 下午5:02:39
 */
public class LongestUncommonSubsequenceI {

  // ！ 真的是个脑筋急转弯吗 ？
  public int findLUSlength(String a, String b) {
    if (Objects.equals(a, b)) {
      return -1;
    }
    return Math.max(a.length(), b.length());
  }

}
