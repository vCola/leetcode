package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @author Very Cola
 * @date 2018年5月25日 上午8:57:16
 */
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    ListNode listNodeResult;
    if (l1.val < l2.val) {
      listNodeResult = l1;
      l1 = l1.next;
    } else {
      listNodeResult = l2;
      l2 = l2.next;
    }

    ListNode pre = listNodeResult;

    while (l1 != null || l2 != null) {
      ListNode next = null;
      if (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          next = l1;
          l1 = l1.next;
        } else {
          next = l2;
          l2 = l2.next;
        }
      } else if (l1 != null) {
        next = l1;
        l1 = l1.next;
      } else if (l2 != null) {
        next = l2;
        l2 = l2.next;
      }

      pre.next = next;
      pre = next;
    }

    return listNodeResult;
  }

  public static void main(String[] args) {

    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;

    ListNode l4 = new ListNode(1);
    ListNode l5 = new ListNode(3);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;

    printListNode(l1);
    printListNode(l4);

    MergeTwoSortedLists mergeTwoLists = new MergeTwoSortedLists();

    printListNode(mergeTwoLists.mergeTwoLists(l1, l4));
  }

  private static void printListNode(ListNode listNode) {
    StringBuilder sb = new StringBuilder();
    while (listNode != null) {
      sb.append(listNode.val);
      if (listNode.next != null) {
        sb.append("->");
      }
      listNode = listNode.next;
    }
    System.out.println(sb.toString());
  }

}
