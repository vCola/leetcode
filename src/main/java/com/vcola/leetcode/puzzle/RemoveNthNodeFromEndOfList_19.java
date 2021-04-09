package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList_19 {


  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slowNode = head;
    ListNode fastNode = head;
    while (n-- > 0) {
      fastNode = fastNode.next;
    }
    if (fastNode == null) {
      return slowNode.next;
    }
    while (fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next;
    }
    slowNode.next = slowNode.next.next;
    return head;
  }

  public ListNode removeNthFromEndV1(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    int size = 1;
    ListNode nextNode = head.next;
    while (nextNode != null) {
      size++;
      nextNode = nextNode.next;
    }
    if (size == n) {
      // remove head
      ListNode newHead = head.next;
      head.next = null;
      return newHead;
    } else {
      ListNode currentNode = head;
      ListNode removedNode = currentNode.next;
      n = size - n;
      while (n-- > 1) {
        currentNode = currentNode.next;
        removedNode = removedNode.next;
      }
      currentNode.next = removedNode.next;
      removedNode.next = null;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 5);
    System.out.println(head);
    head = new RemoveNthNodeFromEndOfList_19().removeNthFromEnd(head, 1);
    System.out.println(head);
  }
}
