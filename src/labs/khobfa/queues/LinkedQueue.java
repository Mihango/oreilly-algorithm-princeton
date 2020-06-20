package labs.khobfa.queues;

public class LinkedQueue<T> implements Queue<T> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public T dequeue() {
        T value = first.item;
        first = first.next;
        --N;
        if(isEmpty())
            last = null;

        return value;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("of");
        queue.enqueue("Java");
        System.out.println("\n Queue size >>>> " + queue.size());
        while (!queue.isEmpty())
            System.out.print(queue.dequeue() + " ");
        System.out.println("\n Queue size >>>> " + queue.size());
     }

}
