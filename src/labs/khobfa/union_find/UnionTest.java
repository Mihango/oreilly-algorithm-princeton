package labs.khobfa.union_find;

import java.util.Arrays;

public class UnionTest {

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);

        System.out.println("Components = " + quickFind.getCount());
        System.out.println("is 2 and 0 connected " + quickFind.isConnected(2, 0));
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);
        quickFind.union(5, 0);
        quickFind.union(7, 2);
        quickFind.union(6, 1);
        System.out.println("is 2 and 0 connected " + quickFind.isConnected(8, 9));

        System.out.println("Components = " + quickFind.getCount() + " >>> " + Arrays.toString(quickFind.getIds()));
    }
}
