package labs.khobfa.tables;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root = null;

    class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public boolean isRed(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private Node rotateLeft(Node h) {
        assert(isRed(h.right));

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }

    private Node rotateRight(Node h) {
        assert(isRed(h.left));

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }

    private void flipColors(Node h) {
        assert(!isRed(h));
        assert(isRed(h.right));
        assert(isRed(h.left));
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    public Iterable<Key> inOrderTraversal() {
        Queue<Key> keys = new LinkedList<>();
        inOrderTraversal(keys, root);
        return keys;
    }

    private void inOrderTraversal(Queue<Key> keys, Node node) {
        if (node.left != null) inOrderTraversal(keys, node.left);
        keys.add(node.key);
        if(node.right != null) inOrderTraversal(keys, node.right);
    }

    public Iterable<Key> levelTraversal() {
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            keys.add(node.key);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return keys;
    }


    public static void main(String[] args) {
        RedBlackBST<Character, Integer> bst = new RedBlackBST<>();
        bst.put('A', 1);
        bst.put('D', 2);
        bst.put('C', 3);
        bst.put('E', 4);
        bst.put('G', 5);
        bst.put('J', 6);

        for (char c : bst.inOrderTraversal()) {
            System.out.print(c + " ");
        }

        System.out.println();

        for (char c : bst.levelTraversal()) {
            System.out.print(c + " ");
        }
    }
}
