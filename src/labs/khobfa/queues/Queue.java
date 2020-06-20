package labs.khobfa.queues;

public interface Queue<T> {
    public void enqueue(T item);
    T dequeue();
    int size();
    boolean isEmpty();
}
