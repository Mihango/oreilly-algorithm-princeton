package labs.khobfa;


// Definition for singly-linked list.
class ListNode {
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
}

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0);
        ListNode result = curr, p = l1, q = l2;
        int carry = 0;

        while(p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            result.next = new ListNode(sum % 10);
            result = result.next;

            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        char z = '1';

        if(carry > 0) {
            result.next = new ListNode(carry);
        }

        return curr.next;
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }

    private static ListNode put(ListNode node, int value) {
        if (node == null) return new ListNode(value);

        node.next = put(node.next, value);
        return node;
    }

    private static int createZero(int count) {
        int r = 1;
        while (count > 0) {
            r *= 10;
            count--;
        }
        return r;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        ListNode l111 = new ListNode(3);
        l11.next = l111;


        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        ListNode l211 = new ListNode(4);
        l21.next = l211;

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
