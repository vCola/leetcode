package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

import java.util.Stack;

/**
 * 234. 回文链表
 *
 * @author Very Cola
 * @date 2018年9月5日 上午11:56:33
 */
public class PalindromeLinkedList_234 {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    // now slow is center node
    ListNode newCenter = reverseList(slow);
    fast = newCenter;
    slow = head;
    boolean isPalindrome = false;
    while (fast != null) {
      if (slow.val != fast.val) {
        break;
      }
      slow = slow.next;
      fast = fast.next;
    }
    if (fast == null) {
      isPalindrome = true;
    }
    // recover structure
    reverseList(newCenter);
    return isPalindrome;
  }

  public boolean isPalindromeV2(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast != null) {
        fast = fast.next;
      }
    }
    // now slow is center node
    Stack<ListNode> stack = new Stack<>();
    while (slow != null) {
      stack.push(slow);
      slow = slow.next;
    }

    // compare
    fast = head;
    while (!stack.isEmpty()) {
      if (stack.pop().val != fast.val) {
        return false;
      }
      fast = fast.next;
    }
    return true;
  }

  public boolean isPalindromeV1(ListNode head) {
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
    ListNode current = node, next, pre = null;
    while (current != null) {
      next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.of(1, 2, 2, 1);
    PalindromeLinkedList_234 palindromeLinkedList = new PalindromeLinkedList_234();
    System.out.println(palindromeLinkedList.isPalindrome(head));
    System.out.println(head);
  }

}
