package labs.khobfa.heaps;

import java.util.HashMap;
import java.util.Iterator;

public class MinHeap implements Iterable<Integer> {
    private final static int DEFAULT_SIZE = 10;
    private Integer[] data;
    private int N;

    public MinHeap() {
        data = new Integer[DEFAULT_SIZE];
    }

    public void insert(int value) {
        if(N == data.length) resize(2 * N);
        data[++N] = value;
        swim(N);
    }

    public Integer delete(int value) {
        int position = -1;
        boolean found = false;

        for(int i = 1; i <= N; i++) {
            if(data[i] == value) {
                position = i;
                found = true;
            }
        }
        if(found) {
            // replace last value with one in position
            data[position] = data[N--];
           if (position > 1 && less(position/2, position))
               swim(position);
           else
               sink(position);
        } else {
            return null;
        }
        return value;
    }

    public int getMin() {
        return data[1];
    }

    private void swim(int index) {
        while (index > 1 && less(index, index/2)) {
            exchange(index, index/2);
            index = index /2;
        }
    }

    private void sink(int index) {
        while (2 * index <= N) {
            int j = 2 * index;
            if (j < N && less(j+1, j)) j++;
            if (less(index, j)) break;
            exchange(index, j);
            index = j;
        }
    }

    private void exchange(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private boolean less(int i, int j) {
        return data[i] < data[j];
    }

    private void resize(int size) {
        Integer[] copy = new Integer[size];
        System.arraycopy(data, 1, copy, 1, N);
        data = copy;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MinIterator();
    }

    private class MinIterator implements Iterator<Integer> {

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
        MinHeap heap = new MinHeap();
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);
        heap.insert(4);

        for (Integer integer : heap)
            System.out.print(integer + " ");

        System.out.println("\n1. minimum == " + heap.getMin());
        heap.delete(1);
        System.out.println("2. minimum == " + heap.getMin());

        for (Integer integer : heap)
            System.out.print(integer + " ");
    }
}
