package labs.khobfa.queues;

public class ResizingArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_CAPACITY = 3;
    private int head;
    private int tail;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }


    @Override
    public void enqueue(T item) {
        if (size() == queue.length) resize(size() * 2);
        queue[tail++] = item;
    }

    @Override
    public T dequeue() {
        T item = queue[head++];
        queue[head - 1] = null;
        if (size() == queue.length / 4) resize(queue.length / 2);
        return item;
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return queue[head] == null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        int total = size();
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(queue, head, copy, 0, total);
        head = 0;
        tail = total;
        queue = copy;
    }

    public void showData() {
        for (T item: queue)
            System.out.print(item + " ");
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> arrayQueue = new ResizingArrayQueue<>();
        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("World");
        arrayQueue.enqueue("of");
        arrayQueue.enqueue("Java");
        System.out.println("\nQueue size >>>> " + arrayQueue.size());
        arrayQueue.showData();
        System.out.println();
        while (!arrayQueue.isEmpty())
            System.out.print(arrayQueue.dequeue() + " ");
        System.out.println("\nQueue size >>>> " + arrayQueue.size());
    }
}
