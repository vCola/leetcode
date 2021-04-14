package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 *
 * @author Very Cola
 * @date 2018年8月15日 上午9:17:48
 */
public class LinkedListCycle_141 {

  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  public boolean hasCycleV2(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (true) {
      // slow走一步
      slow = slow.next;
      if (slow == null) {
        return false;
      }
      // fast走两步
      fast = fast.next;
      if (fast == null) {
        return false;
      }
      fast = fast.next;
      if (fast == null) {
        return false;
      }
      if (slow == fast) {
        return true;
      }
    }
  }

  public boolean hasCycleV1(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    Set<ListNode> set = new HashSet<>();
    while (head != null) {
      if (set.contains(head)) {
        return true;
      }
      set.add(head);
      head = head.next;
    }
    return false;
  }

}
