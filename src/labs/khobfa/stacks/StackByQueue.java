package labs.khobfa.stacks;

import labs.khobfa.queues.LinkedQueue;
import labs.khobfa.queues.Queue;
import labs.khobfa.queues.ResizingArrayQueue;

public class StackByQueue<T> implements Stack<T> {

    private Queue<T> inQueue;
    private Queue<T> outQueue;
    private int N;

    public StackByQueue() {
        inQueue = new ResizingArrayQueue<>();
        outQueue = new ResizingArrayQueue<>();
    }


    @Override
    public T pop() {
        while(inQueue.size() > 1) {
            outQueue.enqueue(inQueue.dequeue());
        }
        T item = inQueue.dequeue();
        Queue<T> copy = inQueue;
        inQueue = outQueue;
        outQueue = copy;
        --N;
        return item;
    }

    @Override
    public void push(T item) {
        inQueue.enqueue(item);
        N++;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        StackByQueue<String> stack = new StackByQueue<>();
        stack.push("Hello");
        stack.push("world");
        stack.push("of");
        stack.push("Java");

        System.out.println(stack.pop());
        System.out.println(stack.pop());


        stack.push("15");
        stack.push(".");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
