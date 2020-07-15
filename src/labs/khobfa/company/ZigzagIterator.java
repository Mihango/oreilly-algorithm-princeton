package labs.khobfa.company;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator implements Iterator<Integer> {
    List<Integer> v1;
    List<Integer> v2;
    boolean isFirst = true;
    int index1 = -1;
    int index2 = -1;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean hasNext() {
        return index1 + 1 < v1.size() || index2 + 1 < v2.size();
    }

    @Override
    public Integer next() {
        if(isFirst) {
            if(v2.size() > index2 + 1) isFirst = false;
            return v1.get(++index1);
        } else {
            if(v1.size() > index1 + 1) isFirst = true;
            return v2.get(++index2);
        }
    }

    public static void main(String[] args) {
        ZigzagIterator iterator = new ZigzagIterator(List.of(1, 3, 5), List.of(2, 4, 6));
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
