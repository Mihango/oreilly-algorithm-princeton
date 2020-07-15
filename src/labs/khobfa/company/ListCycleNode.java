package labs.khobfa.company;

import com.company.ReverseLinkedList.ListNode;

public class ListCycleNode {

    private static ListNode detectCycle(ListNode node) {
        if (node == null || node.next == null) return null;

        ListNode intercept = getIntersect(node);

        if (intercept == null)
            return null;

        ListNode p = node;
        ListNode p2 = intercept;

        while (p != p2) {
            p = p.next;
            p2 = p2.next;
        }
        return p;
    }

    private static ListNode getIntersect(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        l5.next = l1;
        System.out.println(detectCycle(l1));
    }
}
