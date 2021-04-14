package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class ReverseLinkedList2_92 {

  public ListNode reverseBetween(ListNode head, int left, int right) {
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
    ListNode node = new ReverseLinkedList2_92().reverseBetween(head, 1, 3);
    System.out.println(node);
  }
}
