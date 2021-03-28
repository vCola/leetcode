package com.vcola.leetcode.puzzle;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 *
 * @author Very Cola
 * @date 2018年8月27日 上午9:32:39
 */
public class ImplementStackUsingQueues {

  static class MyStack {

    private LinkedList<Integer> queue = new LinkedList<>();
    private LinkedList<Integer> queueTemp = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
      queue.addLast(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
      int result = queue.removeFirst();
      while (!queue.isEmpty()) {
        queueTemp.addLast(result);
        result = queue.removeFirst();
      }

      LinkedList<Integer> queueSwap = queue;
      queue = queueTemp;
      queueTemp = queueSwap;
      return result;
    }

    /**
     * Get the top element.
     */
    public int top() {
      int result = 0;
      while (!queue.isEmpty()) {
        result = queue.removeFirst();
        queueTemp.addLast(result);
      }

      LinkedList<Integer> queueSwap = queue;
      queue = queueTemp;
      queueTemp = queueSwap;
      return result;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
      return queue.isEmpty();
    }
  }

  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    System.out.println(myStack.top());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());

    System.out.println(myStack.empty());
  }

}
