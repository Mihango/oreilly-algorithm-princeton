package labs.khobfa.heaps;

import java.util.Iterator;

public class MaxHeap implements Iterable<Integer> {
    private final static int DEFAULT_SIZE = 10;
    private Integer[] data;
    private int N;

    public MaxHeap() {
        data = new Integer[DEFAULT_SIZE];
    }

    public void insert(int value) {
        if(N == data.length) resize(2 * N);
        data[++N] = value;
        swim(N);
    }

    public int deleteMax() {
        int max = data[1];
        data[1] = data[--N];
        sink(1);
        data[N+1] = null;
        if (N < data.length / 4) resize(N/2);
        return max;
    }

    public int getMax() {
        return data[1];
    }

    private void swim(int index) {
        while (index > 1 && less(index/2, index)) {
            exchange(index, index/2);
            index = index/2;
        }
    }

    private void sink(int index) {
        while (2 * index < N) {
            int j = 2 * index;
            if(less(j, j+1)) j++;
            if (less(j, index)) break;
            exchange(index, j);
            index = j;
        }
    }

    private void resize(int size) {
        Integer[] copy = new Integer[size];
        System.arraycopy(data, 1, copy, 1, N);
        data = copy;
    }

    private void exchange(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private boolean less(int i, int j) {
        return data[i] < data[j];
    }


    @Override
    public Iterator<Integer> iterator() {
        return new MaxIterator();
    }

    private class MaxIterator implements Iterator<Integer> {

        int current = N;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public Integer next() {
            int value = data[current];
            current--;
            return value;
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);

        for (Integer integer : heap)
            System.out.print(integer + " ");
    }
}
