package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 206. 反转链表
 *
 * @author Very Cola
 * @date 2018年8月23日 上午10:59:37
 */
public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode next = null;
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

}
