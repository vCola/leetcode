package com.vcola.leetcode.puzzle;

import com.vcola.leetcode.common.ListNode;

/**
 * 237. 删除链表中的节点
 *
 * @author Very Cola
 * @date 2018年9月5日 下午5:39:24
 */
public class DeleteNodeInLinkedList {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

}
