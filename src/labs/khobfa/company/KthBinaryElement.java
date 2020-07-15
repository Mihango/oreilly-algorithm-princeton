package labs.khobfa.company;

import java.util.Stack;

public class KthBinaryElement {

    private static int smallest(TreeInOrder.TreeNode root, int k) {
        Stack<TreeInOrder.TreeNode> stack = new Stack<>();
        TreeInOrder.TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if(--k == 0) return curr.val;
            curr = curr.right;
        }
        return Integer.MAX_VALUE;
    }
}
