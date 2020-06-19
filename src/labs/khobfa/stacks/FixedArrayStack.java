package labs.khobfa.stacks;

public class FixedArrayStack<T> implements Stack<T> {

    private final T[] stack;
    private int N;

    @SuppressWarnings("unchecked")
    private FixedArrayStack(int capacity) {
        stack = (T[]) new Object[capacity];
    }

    @Override
    public T pop() {
        T item = stack[--N];
        stack[N] = null;
        return item;
    }

    @Override
    public void push(T item) {
        stack[N++] = item;
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
        FixedArrayStack<Integer> stack = new FixedArrayStack<>(5);
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("\nStack size " + stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\nStack size " + stack.isEmpty());
    }
}
