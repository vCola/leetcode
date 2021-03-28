package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 203. 删除链表中的节点
 *
 * @author Very Cola
 * @date 2018年8月22日 上午10:23:35
 */
public class RemoveLinkedListElements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode node = null;
    ListNode pre = null;
    ListNode current = head;
    while (current != null) {
      if (current.val != val) {
        if (pre == null) {
          node = current;
        } else {
          pre.next = current;
        }
        pre = current;
      } else {
        if (current.next == null && pre != null) {
          pre.next = null;
        }
      }
      current = current.next;
    }
    return node;
  }

  public static void main(String[] args) {
    // link
    ListNode head = new ListNode(1);
    ListNode node01 = new ListNode(2);

    head.next = node01;
    System.out.println(head);
    // val
    int val = 1;
    RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
    ListNode node = removeLinkedListElements.removeElements(head, val);
    System.out.println(node);
  }

}
