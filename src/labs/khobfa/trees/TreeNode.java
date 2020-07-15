package labs.khobfa.trees;

import java.util.Queue;

public class TreeNode {
    private Integer value;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(Integer value) {
        this.value = value;
    }

    public void insert(Integer t) {
        int cmp = t.compareTo(value);

        if (cmp < 0) {
            if (left == null) {
                left = new TreeNode(t);
            } else
                left.insert(t);
        }
        else if (cmp > 0) {
            if (right == null) {
                right = new TreeNode(t);
            } else {
                right.insert(t);
            }
        }
    }

    public void inOrderTraversal(TreeNode node, Queue<Integer> queue) {
        if (node.left != null)
            inOrderTraversal(node.left, queue);

        queue.add(node.value);

        if (node.right != null)
            inOrderTraversal(node.right, queue);
    }

    public Integer getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
