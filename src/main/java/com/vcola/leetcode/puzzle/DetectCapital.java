package com.vcola.leetcode.puzzle;

/**
 * 520. 检测大写字母
 *
 * @author Very Cola
 * @date 2019年4月11日 上午9:51:31
 */
public class DetectCapital {

  public boolean detectCapitalUse(String word) {
    int bitN = 0, length = word.length();
    for (int index = 0; index < length; index++) {
      char c = word.charAt(index);
      if (c >= 'A' && c <= 'Z') {
        bitN = (bitN << 1) + 1;
      } else {
        bitN = (bitN << 1);
      }
    }

    return bitN == 0 || bitN == 1 << (length - 1) || bitN == (1 << length) - 1;
  }

  public static void main(String[] args) {
    DetectCapital detectCapital = new DetectCapital();
    System.out.println(detectCapital.detectCapitalUse("G"));

    System.out.println((int) 'A');
    System.out.println((int) 'Z');
    System.out.println((int) 'a');
    System.out.println((int) 'z');
  }

}
