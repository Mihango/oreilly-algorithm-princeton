package labs.khobfa.company;

import com.company.ReverseLinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode hasCycle(ListNode node, Map<ListNode, Integer> map) {
        ListNode slow = node;
        ListNode fast = node.next;
        int count = 0;
        map.put(node, ++count);

        while (fast != slow) {
            if (fast == null || fast.next == null)
                return slow;

            map.put(fast, ++count);
            map.put(fast.next, ++count);

            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }

    public static ListNode detectCycle(ListNode node) {
        if (node == null || node.next == null) return null;

        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cycle = hasCycle(node, map);

        if (cycle != null) {
            ListNode p = node;
            ListNode p1 = cycle;

            while (p != p1) {
                p = p.next;
                p1 = p1.next;
            }
            return p;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        l5.next = l2;

        System.out.println(hasCycle(l1));
        System.out.println(detectCycle(l1));
    }
}
