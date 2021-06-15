package com.vcola.leetcode.common;

public class ListNode {

  public int val;

  public ListNode next;

  public ListNode() {
  }

  public ListNode(int x) {
    val = x;
    next = null;
  }

  public static ListNode of(int... values) {
    if (values == null || values.length == 0) {
      return null;
    }

    ListNode root = new ListNode(values[0]);
    ListNode pre = root;
    for (int i = 1; i < values.length; i++) {
      ListNode node = new ListNode(values[i]);
      pre.next = node;
      pre = node;
    }
    return root;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    ListNode node = this;
    while (node != null) {
      sb.append(node.val);
      node = node.next;
      if (node != null) {
        sb.append("->");
      }
    }
    return sb.toString();
  }
}
