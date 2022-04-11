package wiki.laona.lc;

import java.util.HashSet;

/**
 * @author laona
 * @description 链表中环的检测
 * @create 2022-04-11 23:56
 **/
public class _141_HasCycle {


    /**
     * Definition for singly-linked list.
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        // 快慢指针解决
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            // ListNode slow = head;
            ListNode fast = head.next;
            while (head != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                head = head.next;
                fast = fast.next.next;
            }
            return true;
        }

        // HashSet 解法
        public class Solution2 {
            public boolean hasCycle(ListNode head) {
                if (head == null || head.next == null) {
                    return false;
                }
                HashSet<ListNode> set = new HashSet<>();
                while(head != null) {
                    // true if this set did not already contain the specified element
                    if (!set.add(head)) {
                        return true;
                    }
                    head = head.next;
                }
                return false;
            }
        }
    }
}
