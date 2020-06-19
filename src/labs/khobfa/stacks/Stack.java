package labs.khobfa.stacks;

public interface Stack<T> {
    T pop();
    void push(T item);
    boolean isEmpty();
    int size();
}
