package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class ReverseLinkedList_206 {

  public ListNode reverseList(ListNode head) {
    if (head.next == null) {
      return head;
    }
    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }

  public ListNode reverseListV1(ListNode head) {
    ListNode current = head;
    ListNode next;
    ListNode pre = null;
    while (current != null) {
      next = current.next;
      if (pre != null) {
        current.next = pre;
      } else {
        current.next = null;
      }
      pre = current;
      current = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 5);
    head = new ReverseLinkedList_206().reverseList(head);
    System.out.println(head);
  }

}
