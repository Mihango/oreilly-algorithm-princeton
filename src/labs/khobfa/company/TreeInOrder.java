package labs.khobfa.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeInOrder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static List<Integer> traverseIter(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    private static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int inOrder = -Integer.MAX_VALUE;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val <= inOrder) return false;
            inOrder = curr.val;
            curr = curr.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t2 = new TreeNode(6, null, null);
        TreeNode t3 = new TreeNode(8, null, null);
        TreeNode t4 = new TreeNode(7, t2, t3);
        TreeNode t5 = new TreeNode(5, t1, t4);

        System.out.println(isValidBST(t5));
        for (int val : traverseIter(t5)) {
            System.out.print(val + " ");
        }
    }
}
