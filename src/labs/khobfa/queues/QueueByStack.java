package labs.khobfa.queues;

import labs.khobfa.stacks.ResizingArrayStack;
import labs.khobfa.stacks.Stack;

public class QueueByStack<T> implements Queue<T> {
    private final Stack<T> outStack;
    private final Stack<T> inStack;
    private int N;

    private QueueByStack(){
        outStack = new ResizingArrayStack<>();
        inStack = new ResizingArrayStack<>();
    }

    @Override
    public void enqueue(T item) {
        inStack.push(item);
        N++;
    }

    @Override
    public T dequeue() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        --N;
        return outStack.pop();
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("Hello");
        queue.enqueue("world");
        queue.enqueue("of");
        queue.enqueue("Java");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


        queue.enqueue("15");
        queue.enqueue(".");

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}
