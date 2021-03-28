package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 *
 * @author Very Cola
 * @date 2018年6月6日 上午8:57:41
 */
public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode current = head;
    ListNode next = head.next;
    while (next != null) {
      if (next.val != current.val) {
        current.next = next;
        current = next;
      }

      next = next.next;
    }

    current.next = null;

    return head;
  }

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode next01 = new ListNode(1);
    ListNode next02 = new ListNode(2);
    ListNode next03 = new ListNode(3);
    ListNode next04 = new ListNode(3);
    ListNode next05 = new ListNode(3);

    head.next = next01;
    next01.next = next02;
    next02.next = next03;
    next03.next = next04;
    next04.next = next05;

    RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

    head = removeDuplicatesFromSortedList.deleteDuplicates(head);

    while (head != null) {
      System.out.print(head.val + "->");
      head = head.next;
    }

  }

}
