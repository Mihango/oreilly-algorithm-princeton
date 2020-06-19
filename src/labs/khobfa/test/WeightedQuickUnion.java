package labs.khobfa.test;

import java.util.Arrays;

public class WeightedQuickUnion {
    private int[] ids;
    private int[] weight;
    private int count;

    public WeightedQuickUnion(int size) {
        this.count = size;
        this.weight = new int[size];
        this.ids = new int[size];

        for(int i =0; i < size; i++) {
            ids[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        System.out.print(" ---> " + (ids.length - count + 1));
        if (pRoot == qRoot) return;

        if(weight[pRoot] < weight[qRoot]) {
            ids[pRoot] = qRoot;
        } else {
            ids[qRoot] = pRoot;
        }
        count--;
    }

    public int[] getIds() {
        return ids;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        WeightedQuickUnion quickUnion = new WeightedQuickUnion(6);
//        quickUnion.union(0,1);
//        quickUnion.union(1, 2);
//        quickUnion.union(4, 5);
//        quickUnion.union(2, 3);
//        quickUnion.union(0, 4);
        quickUnion.union(0, 0);
        quickUnion.union(0, 1);
        quickUnion.union(1, 2);
        quickUnion.union(2, 1);

        System.out.println("\nConnected components >>> " + quickUnion.getCount());
        System.out.println(Arrays.toString(quickUnion.getIds()));
    }
}
