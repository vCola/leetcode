package com.vcola.leetcode.puzzle;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * @author Very Cola
 * @date 2018年8月22日 上午11:06:52
 */
public class CountPrimes {

  public int countPrimes01(int n) {
    boolean[] prime = new boolean[n];
    Arrays.fill(prime, true);
    for (int i = 2; i < n; i++) {
      if (prime[i]) {
        if (isPrime(i)) {
          for (int j = i * 2; j < n; j += i) {
            prime[j] = false;
          }
        }
      }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (prime[i]) {
        count++;
      }
    }
    return count;
  }

  public int countPrimes(int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        count++;
      }
    }
    return count;
  }

  private boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    int max = (int) Math.sqrt(num);
    for (int i = 2; i <= max; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    CountPrimes countPrimes = new CountPrimes();
    System.out.println(countPrimes.countPrimes01(2));

    System.out.println(countPrimes.isPrime(2));
  }

}
