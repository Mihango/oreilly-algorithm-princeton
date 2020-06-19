package labs.khobfa.test;

import java.util.Arrays;

public class QuickUnion {
    private int ids[];
    private int count;

    public QuickUnion(int size) {
        this.count = size;
        this.ids = new int[size];

        for (int i =0; i < size; i++) {
            ids[i] = i;
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

        if(pRoot == qRoot) return;

        ids[pRoot] = qRoot;
        count--;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int[] getIds() {
        return ids;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(6);
        quickUnion.union(0,1);
        quickUnion.union(1, 2);
        quickUnion.union(4, 5);

        System.out.println("Connected components >>> " + quickUnion.getCount());
        System.out.println(Arrays.toString(quickUnion.getIds()));

    }
}
