package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class RotateList_61 {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k <= 0) {
      return head;
    }
    // size
    int size = 1;
    ListNode nextNode = head.next;
    ListNode tail = null;
    while (nextNode != null) {
      tail = nextNode;
      size++;
      nextNode = nextNode.next;
    }
    k %= size;
    if (k == 0) {
      return head;
    }
    // rotate
    tail.next = head;
    ListNode newTail = head;
    ListNode newHead = newTail.next;
    k = size - k;
    while (k-- > 1) {
      newTail = newTail.next;
      newHead = newTail.next;
    }

    newTail.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 5);
    System.out.println(head);
    head = new RotateList_61().rotateRight(head, 5);
    System.out.println(head);
  }

}
