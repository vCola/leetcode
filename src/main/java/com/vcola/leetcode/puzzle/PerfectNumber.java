package com.vcola.leetcode.puzzle;

/**
 * 507. 完美数
 *
 * @author Very Cola
 * @date 2019年4月6日 上午10:12:59
 */
public class PerfectNumber {

  public boolean checkPerfectNumber(int num) {
    if (num == 1) {
      return false;
    }
    int size = (int) Math.sqrt(num);
    int sum = 1;
    for (int i = 2; i <= size; i++) {
      if (num % i == 0) {
        sum += i + num / i;
      }
    }
    return sum == num;
  }

  public boolean checkPerfectNumberV1(int num) {
    if (num == 1) {
      return false;
    }

    int size = num / 2;
    boolean[] skipped = new boolean[size + 1];

    int sum = 1;
    for (int i = 2; i <= size; i++) {
      if (skipped[i]) {
        continue;
      }
      if (num % i == 0) {
        sum += i;
      } else {
        // 设置skipped
        for (int j = i, z = 1; j <= size; z++, j = z * j) {
          skipped[j] = true;
        }
      }
    }
    return sum == num;
  }

  public static void main(String[] args) {
    PerfectNumber perfectNumber = new PerfectNumber();
    System.out.println(perfectNumber.checkPerfectNumber(28));
    System.out.println(perfectNumber.checkPerfectNumber(99999997));
  }
}
