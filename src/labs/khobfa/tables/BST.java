package labs.khobfa.tables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    class Node {
        Key key;
        Value value;
        Node left, right;
        int count;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);

        int cmp = key.compareTo(node.key);

        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        node.count = 1 + size(node.left) + size(node.right);

        return node;
    }

    private Node get(Key key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node;
        }
        return null;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return node;

        int cmp = key.compareTo(node.key);

        if (cmp < 0) node.left = delete(node.left, key);
        else if(cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = min(node.right);
            delete(node.right, min.key);
        }
        return node;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
         return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.count;
    }

    private Node min(Node node) {
        if (node.left != null)
            return min(node.left);
        else
            return node;
    }

    public Iterator<Key> keys() {
        return new KeyIterator();
    }

    public Iterator<Value> values() {
        return new ValueIterator();
    }

    class KeyIterator implements Iterator<Key> {
        Queue<Node> queue = new LinkedList<>();

        KeyIterator() {
           if (root != null)
               queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Key next() {
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            return node.key;
        }
    }

    class ValueIterator implements Iterator<Value> {
        Queue<Node> queue = new LinkedList<>();

        ValueIterator() {
            if (root != null)
                queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Value next() {
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            return node.value;
        }
    }

}
