package com.vcola.leetcode.others;

import com.vcola.leetcode.common.ListNode;

public class RemoveDupNode {

  public static ListNode removeDup(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode();
    ListNode prePre = dummy;
    ListNode cur = head, next;
    boolean dup = false;
    while (cur != null) {
      next = cur.next;
      if (next != null && next.val == cur.val) {
        // 重复
        dup = true;
      } else {
        // 当前和next不重复, 且上个元素和上上个元素也不重复
        if (!dup) {
          prePre.next = cur;
          prePre = cur;
          cur.next = null;
        }
        dup = false;
      }
      cur = next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNode.of(0, 0, 1, 4, 4, 5, 6, 7, 7, 7, 9);
    ListNode result = removeDup(listNode);
    System.out.println(result);
  }

}
