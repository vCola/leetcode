package com.vcola.leetcode.others;

import com.vcola.leetcode.common.ListNode;

public class ReversePartialListNode {

  public ListNode revere(ListNode head, int m) {
    ListNode slow = head;
    ListNode fast = head;
    while (m-- > 0) {
      fast = fast.next;
    }
    if (fast == null) {
      return head;
    }
    ListNode pre = null;
    while (fast != null) {
      fast = fast.next;
      ListNode next = slow.next;
      slow.next = pre;
      pre = slow;
      slow = next;
    }
    head.next = slow;
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ListNode node = new ReversePartialListNode().revere(head, 5);
    System.out.println(node);
  }

}
