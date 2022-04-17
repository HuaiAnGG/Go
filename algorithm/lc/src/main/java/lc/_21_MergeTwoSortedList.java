package lc;

/**
 * @author laona
 * @description 合并两个有序链表
 * @create 2022-04-17 14:01
 **/
public class _21_MergeTwoSortedList {

    public static void main(String[] args) {
        //[1,2,4]
        ListNode listNode1 = new ListNode(
                1, new ListNode(2, new ListNode(5))
        );

        ListNode listNode2 = new ListNode(
                1, new ListNode(3, new ListNode(4))
        );

        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println("listNode = " + listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }else {
            list1.next = mergeTwoLists(list2, list1.next);
            return list1;
        }
    }
}
