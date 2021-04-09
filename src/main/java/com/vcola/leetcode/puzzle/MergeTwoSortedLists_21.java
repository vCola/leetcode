package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * @author Very Cola
 * @date 2018年5月25日 上午8:57:16
 */
public class MergeTwoSortedLists_21 {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    return null;
  }

  public ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode preNode = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        preNode = preNode.next = l1;
        l1 = l1.next;
      } else {
        preNode = preNode.next = l2;
        l2 = l2.next;
      }
    }
    if (l1 != null) {
      preNode.next = l1;
    }
    if (l2 != null) {
      preNode.next = l2;
    }
    return dummyHead.next;
  }

  public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode resultNode, node1, node2, pre;
    if (l1.val < l2.val) {
      resultNode = l1;
      node1 = l1.next;
      node2 = l2;
    } else {
      resultNode = l2;
      node2 = l2.next;
      node1 = l1;
    }
    pre = resultNode;
    while (node1 != null && node2 != null) {
      ListNode next;
      if (node1.val < node2.val) {
        next = node1;
        node1 = node1.next;
      } else {
        next = node2;
        node2 = node2.next;
      }
      pre = pre.next = next;
    }
    if (node1 != null) {
      pre.next = node1;
    }
    if (node2 != null) {
      pre.next = node2;
    }

    return resultNode;
  }

  public ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
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
    ListNode l1 = ListNode.of(1, 2, 10, 30);
    ListNode l2 = ListNode.of(0, 3, 4);
    ListNode listNode = new MergeTwoSortedLists_21().mergeTwoLists(l1, l2);
    System.out.println(listNode);
  }

}
