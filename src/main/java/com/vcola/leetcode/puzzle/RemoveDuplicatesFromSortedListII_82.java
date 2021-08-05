package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class RemoveDuplicatesFromSortedListII_82 {

  public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
      // 判断当前节点的下一个节点是否重复
      if (cur.next.val == cur.next.next.val) {
        int val = cur.next.val;
        // 将cur之后的所有等于val的节点删除
        while (cur.next != null && cur.next.val == val) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }

}
