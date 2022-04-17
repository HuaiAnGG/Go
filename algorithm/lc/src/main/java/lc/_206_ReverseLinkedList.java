package lc;

/**
 * @author laona
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206-反转链表</a>
 * @create 2022-04-10 13:19
 **/
public class _206_ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head;
            ListNode prev = null;
            while(next != null) {
                head = head.next;
                next.next = prev;
                prev = next;
                next = head;
            }

            return prev;
        }
    }
}
