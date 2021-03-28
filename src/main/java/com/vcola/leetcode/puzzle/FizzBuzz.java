package com.vcola.leetcode.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * @author Very Cola
 * @date 2018年11月8日 上午9:34:59
 */
public class FizzBuzz {

  public static void main(String[] args) {
    FizzBuzz fizzBuzz = new FizzBuzz();
    System.out.println(fizzBuzz.fizzBuzz(100));
  }

  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      String s = fizzBuzzOf(i);
      if (s == null) {
        result.add("" + i);
      } else {
        result.add(s);
      }
    }
    return result;
  }

  private String fizzBuzzOf(int n) {
    if (n % 15 == 0) {
      return "FizzBuzz";
    }

    if (n % 5 == 0) {
      return "Buzz";
    }

    if (n % 3 == 0) {
      return "Fizz";
    }
    return null;
  }

}
