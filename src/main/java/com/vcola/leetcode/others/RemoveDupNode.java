package com.vcola.leetcode.others;

import com.vcola.leetcode.common.ListNode;

public class RemoveDupNode {

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode root = new ListNode(-1);
    root.next = head;
    ListNode cur = root;
    while (cur.next != null && cur.next.next != null) {
      if (cur.next.val == cur.next.next.val) {
        int tmp = cur.next.val;
        while (cur.next != null && tmp == cur.next.val) {
          cur.next = cur.next.next;
        }
      } else {
        cur = cur.next;
      }
    }
    return root.next;
  }

  public static ListNode removeDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
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
    ListNode listNode = ListNode.of(1, 1, 0);
    ListNode result = removeDuplicates(listNode);
    System.out.println(result);
  }
}
