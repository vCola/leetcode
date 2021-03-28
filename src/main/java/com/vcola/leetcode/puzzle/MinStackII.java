package com.vcola.leetcode.puzzle;

import java.util.Stack;

/**
 * 155 最小栈 实现
 *
 * @author Very Cola
 * @date 2018年8月16日 上午9:18:29
 */
public class MinStackII {

  private Stack<MinPair> stack = new Stack<>();

  /**
   * initialize your data structure here.
   */
  public MinStackII() {
  }

  public void push(int x) {
    int min = x;
    if (!stack.isEmpty()) {
      min = Math.min(min, getMin());
    }
    stack.push(new MinPair(x, min));
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek().value;
  }

  public int getMin() {
    return stack.peek().min;
  }

  private static class MinPair {
    private int value;
    private int min;

    private MinPair(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  public static void main(String[] args) {
    MinStackII minStack = new MinStackII();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());

    System.out.println(minStack.getMin());
  }

}
