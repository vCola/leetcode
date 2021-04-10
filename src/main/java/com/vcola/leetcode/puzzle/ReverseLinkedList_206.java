package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class ReverseLinkedList_206 {

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public ListNode reverseListV2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode last = reverseListV2(head.next);
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
      current.next = pre;
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
