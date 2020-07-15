package labs.khobfa.company;

import javax.swing.event.ListDataEvent;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next.val +
                    '}';
        }
    }

    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode p = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode c = l1;
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }

        c = reverseList(l1);

        System.out.println();
        while (c != null) {
            System.out.print(c.val + " ");
            c = c.next;
        }
    }
}
