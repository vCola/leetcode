package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class InsertionSortList_147 {

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode waitInsertNode = head.next;
    while (waitInsertNode != null) {
      ListNode currentNode = head;
      while (currentNode != waitInsertNode) {
        if (waitInsertNode.val <= currentNode.val) {
          // swap next.val and temp.val
          int tempVal = waitInsertNode.val;
          waitInsertNode.val = currentNode.val;
          currentNode.val = tempVal;
        }
        currentNode = currentNode.next;
      }

      waitInsertNode = waitInsertNode.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of( 3, 4, 2, 0, 0, 13, 2323, 22323, 12);
    System.out.println(head);
    head = new InsertionSortList_147().insertionSortList(head);
    System.out.println(head);
  }
}
