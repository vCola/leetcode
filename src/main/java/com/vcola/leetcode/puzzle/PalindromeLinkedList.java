package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 234. 回文链表
 *
 * @author Very Cola
 * @date 2018年9月5日 上午11:56:33
 */
public class PalindromeLinkedList {

  /**
   * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   *
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    int length = 0;
    ListNode node = head;
    while (node != null) {
      length++;
      node = node.next;
    }

    if (length == 1) {
      return true;
    }

    int mid = (length + 1) / 2;
    node = head;
    while (mid-- > 0) {
      node = node.next;
    }

    node = reverseList(node);
    mid = length / 2;
    while (mid-- > 0) {
      if (node.val != head.val) {
        return false;
      }
      node = node.next;
      head = head.next;
    }

    return true;
  }

  private ListNode reverseList(ListNode node) {
    ListNode current = node;
    ListNode next = null;
    ListNode pre = null;
    while (current != null) {
      next = current.next;
      if (pre != null) {
        current.next = pre;
      } else {
        current.next = null;
      }
      pre = current;
      current = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 3, 4, 3, 2, 1, 5);
    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    System.out.println(palindromeLinkedList.isPalindrome(head));
  }

}
