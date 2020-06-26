package labs.khobfa.queues;

import java.util.Iterator;

public class ResizingArrayQueue<T> implements Queue<T>, Iterable<T>  {
    private static final int DEFAULT_CAPACITY = 3;
    private int head;
    private int tail;
    private T[] queue;
    private int N;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
    }


    @Override
    public void enqueue(T item) {
        if (size2() == queue.length) resize(size2() * 2);
        queue[tail++] = item;
        N++;
    }

    @Override
    public T dequeue() {
        T item = queue[head++];
        queue[head - 1] = null;
        if (size2() == queue.length / 4) resize(queue.length / 2);
        --N;
        return item;
    }

    public T findMiddle() {
        return queue[size2() /2];
    }

    public T deleteMiddle() {
        int m = size2()/2;
        T middle = queue[m];
        queue[m] = null;
        --N;
        return middle;
    }

    @Override
    public int size() {
        return N;
    }

    private int size2() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail && queue[head] == null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        int total = size2();
        T[] copy = (T[]) new Object[capacity];
        tail = arrayCopy(queue, head, copy, total);
        head = 0;
        queue = copy;
    }

    private int arrayCopy(T[] source, int start, T[] dest, int size) {
        int count = 0;
        for(int i = start; i < start + size; i++) {
            if(source[i] != null) {
                dest[count++] = source[i];
            }
        }
        return count;
    }

    public void showData() {
        for (T item: queue)
            System.out.print(item + " ");
    }

    @Override
    public Iterator<T> iterator() {
        System.out.println("\n tail >>>> " + tail + " >>>> head " + head + " \n");
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        private int current = tail;

        @Override
        public boolean hasNext() {
            return current > head;
        }

        @Override
        public T next() {
            return queue[--current];
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> arrayQueue = new ResizingArrayQueue<>();
        arrayQueue.enqueue("Hello");
        arrayQueue.enqueue("World");
        arrayQueue.enqueue("of");
        arrayQueue.enqueue("Java");

        System.out.println("\nQueue size >>>> " + arrayQueue.size() + " middle >>> " + arrayQueue.findMiddle());
        System.out.println("Delete middle >>> " + arrayQueue.deleteMiddle());
        System.out.println("\nQueue size >>>> " + arrayQueue.size());
        arrayQueue.showData();
        System.out.println();

//        while (!arrayQueue.isEmpty())
//            System.out.print(arrayQueue.dequeue() + " ");
//        System.out.println("\nQueue size >>>> " + arrayQueue.size());

        System.out.print("Showing queue iterator");
        for (String s : arrayQueue) {
            System.out.print(s + " ");
        }
    }
}
