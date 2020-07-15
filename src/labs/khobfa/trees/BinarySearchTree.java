package labs.khobfa.trees;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Integer value) {
        if (root == null)
            root = new TreeNode(value);
        else
            root.insert(value);
    }

    public TreeNode delete(Integer value) {
        return delete(root, value);
    }

    private TreeNode delete(TreeNode root, Integer value) {
        if (root == null) return root;

        if (value < root.getValue()) {
            root.setLeft(delete(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(delete(root.getRight(), value));
        }
        else {
            if (root.getLeft() == null)
                return root.getRight();
            else if(root.getRight() == null)
                return root.getLeft();

            root.setValue(min(root.getRight()));
            root.setRight(delete(root.getRight(), root.getValue()));
        }
        return root;
    }

    private Iterable<Integer> inOrderTraversal() {
        Queue<Integer> queue = new LinkedList<>();
        root.inOrderTraversal(root, queue);
        return queue;
    }

    private int min(TreeNode node) {
        int min = node.getValue();
        while (node.getLeft() != null) {
            min = min(node.getLeft());
            node = node.getLeft();
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(11);
        tree.insert(10);
        tree.insert(1);
        tree.insert(15);
        tree.insert(17);

        for (int i : tree.inOrderTraversal()) {
            System.out.print(i + " ");
        }

        tree.delete(17);

        System.out.println("Deleted 17");
        for (int i : tree.inOrderTraversal()) {
            System.out.print(i + " ");
        }

        tree.delete(6);

        System.out.println("Deleted 6");
        for (int i : tree.inOrderTraversal()) {
            System.out.print(i + " ");
        }
    }
}
