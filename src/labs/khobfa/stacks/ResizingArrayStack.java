package labs.khobfa.stacks;

public class ResizingArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 3;
    private T[] data;
    private int N;

    @SuppressWarnings("unchecked")
    public ResizingArrayStack() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T pop() {
        T item = data[--N];
        data[N] = null;
        if(N > 0 && N == data.length / 4) resize(data.length / 2);
        return item;
    }

    @Override
    public void push(T item) {
        if (N == data.length) resize(N);
        data[N++] = item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @SuppressWarnings("unchecked")
    private void resize(int size) {
        T[] copy = (T[]) new Object[2 * size];
        System.arraycopy(data, 0, copy, 0, N);
        data = copy;
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
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
