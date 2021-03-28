package com.vcola.leetcode.puzzle;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * @author Very Cola
 * @date 2018年9月5日 上午11:47:56
 */
public class ImplementQueueUsingStacks {

  static class MyQueue {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
      stack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
      int pre = stack.pop();
      while (!stack.isEmpty()) {
        tempStack.push(pre);
        pre = stack.pop();
      }
      while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
      }
      return pre;
    }

    /**
     * Get the front element.
     */
    public int peek() {
      int pre = 0;
      while (!stack.isEmpty()) {
        pre = stack.pop();
        tempStack.push(pre);
      }

      while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
      }
      return pre;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
      return stack.isEmpty();
    }
  }

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);

    System.out.println(myQueue.peek());
    System.out.println(myQueue.pop());
    System.out.println(myQueue.empty());
    System.out.println(myQueue.pop());
    System.out.println(myQueue.empty());
  }

}
