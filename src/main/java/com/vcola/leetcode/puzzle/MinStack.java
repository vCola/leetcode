package com.vcola.leetcode.puzzle;

import java.util.LinkedList;

/**
 * 155. 最小栈
 *
 * @author Very Cola
 * @date 2018年8月15日 上午9:51:15
 */
public class MinStack {

  private int min = Integer.MAX_VALUE;

  private LinkedList<Integer> stack;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    stack = new LinkedList<>();
  }

  public void push(int x) {
    stack.addLast(x);
    if (x < min) {
      min = x;
    }
  }

  public void pop() {
    int temp = stack.removeLast();
    if (temp == min) {
      min = Integer.MAX_VALUE;
      for (int v : stack) {
        if (v < min) {
          min = v;
        }
      }
    }
  }

  public int top() {
    return stack.getLast();
  }

  public int getMin() {
    return min;
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);

    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());

    System.out.println(minStack.getMin());
  }

}
