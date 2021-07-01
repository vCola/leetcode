package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class ReverseLinkedList2_92 {

  public static ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    ListNode pre = null, cur = dummyNode;
    for (int i = 0; i < left; i++) {
      pre = cur;
      cur = cur.next;
    }
    // reverse
    ListNode rightStart = cur, rightPre = null, rightCur = cur, rightNext;
    for (int i = left - 1; i < right; i++) {
      rightNext = rightCur.next;
      rightCur.next = rightPre;
      rightPre = rightCur;
      rightCur = rightNext;
    }
    pre.next = rightPre;
    rightStart.next = rightCur;
    return dummyNode.next;
  }

  public ListNode reverseBetweenV1(ListNode head, int left, int right) {
    ListNode pre = null;
    ListNode leftNode = head;
    while (left-- > 1) {
      pre = leftNode;
      leftNode = leftNode.next;
    }
    ListNode rightNode = head;
    while (right-- > 0) {
      rightNode = rightNode.next;
    }
    ListNode pre2 = null;
    ListNode cur = leftNode;
    while (cur != rightNode) {
      ListNode next = cur.next;
      cur.next = pre2;
      pre2 = cur;
      cur = next;
    }
    // 表示 head未被 反转
    if (pre != null) {
      pre.next = pre2;
      leftNode.next = rightNode;
      return head;
    }
    leftNode.next = rightNode;
    return pre2;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 5);
    ListNode node = reverseBetween(head, 1, 3);
    System.out.println(node);
  }
}
