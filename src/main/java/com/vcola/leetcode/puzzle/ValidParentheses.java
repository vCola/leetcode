package com.vcola.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 20. 有效的括号
 *
 * @author Very Cola
 * @date 2018年5月24日 上午9:03:30
 */
public class ValidParentheses {

  public boolean isValid(String s) {

    Map<Character, Character> parenthesesPair = new HashMap<>();
    parenthesesPair.put(')', '(');
    parenthesesPair.put('}', '{');
    parenthesesPair.put(']', '[');

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (parenthesesPair.containsValue(c)) {
        stack.push(c);
      } else if (parenthesesPair.containsKey(c)) {
        if (stack.isEmpty() || !Objects.equals(parenthesesPair.get(c), stack.pop())) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {

    ValidParentheses isValidBracket = new ValidParentheses();

    System.out.println(isValidBracket.isValid("()[]"));

  }

}
