package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 160. 相交链表
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author Very Cola
 * @date 2018年8月16日 上午9:30:12
 */
public class IntersectionOfTwoLinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    int diff = 0;
    ListNode nodeA = headA.next;
    ListNode nodeB = headB.next;
    ListNode longerNode = null;
    while (nodeA != null || nodeB != null) {
      if (nodeA == null) {
        diff++;
        longerNode = headB;
      }
      if (nodeB == null) {
        diff++;
        longerNode = headA;
      }
      if (nodeA != null) {
        nodeA = nodeA.next;
      }
      if (nodeB != null) {
        nodeB = nodeB.next;
      }
    }

    if (longerNode == headA) {
      nodeA = headA;
      nodeB = headB;
    } else if (longerNode == headB) {
      nodeA = headB;
      nodeB = headA;
    } else {
      nodeA = headA;
      nodeB = headB;
    }

    while (diff > 0) {
      nodeA = nodeA.next;
      diff--;
    }

    while (nodeA != null) {
      if (nodeA == nodeB) {
        return nodeA;
      }
      nodeA = nodeA.next;
      nodeB = nodeB.next;
    }
    return null;
  }

  public static void main(String[] args) {
		/*ListNode headA = new ListNode(3);
		ListNode anode1 = new ListNode(1);
		ListNode headB = new ListNode(5);
		
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(0);
		
		headA.next = anode1;
		anode1.next = node2;
		node2.next = node3;
		headB.next = node2;*/
    ListNode headA = new ListNode(1);
    ListNode headB = headA;

    System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB));

  }

}
