package com.vcola.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

import com.vcola.leetcode.common.ListNode;

/**
 * 141. 环形链表
 *
 * @author Very Cola
 * @date 2018年8月15日 上午9:17:48
 */
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
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
