package labs.khobfa.union_find;

import java.util.Arrays;

public class UnionTest {

    public static void main(String[] args) {
        QuickUnion quickFind = new QuickUnion(10);
//        QuickFind quickFind = new QuickFind(10);

//         System.out.println("Components = " + quickFind.getCount());
//         System.out.println("is 2 and 0 connected " + quickFind.isConnected(2, 0));
        quickFind.union(4, 3);
        quickFind.union(3, 8);
        quickFind.union(6, 5);
        quickFind.union(9, 4);
        quickFind.union(2, 1);
        quickFind.union(5, 0);
        quickFind.union(7, 2);
        quickFind.union(6, 1);
        quickFind.union(0, 9);
        System.out.println("is 2 and 0 connected " + quickFind.isConnected(8, 9));
//         System.out.println("Components = " + quickFind.getCount() + " >>> " + Arrays.toString(quickFind.getIds()));
//        System.out.println("Node 3 is in component  = " + quickFind.find(3));

//        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(5);
        WeightedPathCompressed weightedQuickUnion = new WeightedPathCompressed(5);
        weightedQuickUnion.union(0, 1);
        weightedQuickUnion.union(2, 4);
        System.out.println("Count >> " + weightedQuickUnion.getCount());
        weightedQuickUnion.union(3, 4);
//        weightedQuickUnion.union(3, 0);
        System.out.println("ids >>> " + Arrays.toString(weightedQuickUnion.getIds()));
        System.out.println("size>>> " + Arrays.toString(weightedQuickUnion.getWeight()));

    }
}
