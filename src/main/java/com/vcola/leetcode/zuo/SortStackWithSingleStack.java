package com.vcola.leetcode.zuo;

import com.vcola.leetcode.utils.LeetUtil;

import java.util.Stack;

public class SortStackWithSingleStack {

  // stack 待排序的栈
  public void sort(Stack<Integer> stack) {
    Stack<Integer> help = new Stack<>();
    while (!stack.isEmpty()) {
      int cur = stack.pop();
      // find the largest one
      while (!help.isEmpty() && help.peek() < cur) {
        stack.push(help.pop());
      }
      help.push(cur);
    }

    // trans help to stack
    while (!help.isEmpty()) {
      stack.push(help.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    int[] nums = LeetUtil.randomUkArray(5, 10);
    for (int num : nums) {
      stack.push(num);
    }
    System.out.println(stack);
    // sort
    new SortStackWithSingleStack().sort(stack);
    System.out.println(stack);
  }

}
