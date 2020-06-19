package labs.khobfa.stacks;

public class LinkedStackOfStrings<T> implements Stack<T> {
    private int N;
    private Node first = null;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
        --N;
        return item;
    }

    @Override
    public void push(T item) {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        ++N;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings<String> stack = new LinkedStackOfStrings<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("of");
        stack.push("Java");

        System.out.println("\nStack size " + stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\nStack size " + stack.isEmpty());
    }
}
