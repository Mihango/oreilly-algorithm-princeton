package labs.khobfa.test;

import java.util.Arrays;

public class QuickFind {

    private final int[] ids;
    private int count;

    public QuickFind(int size) {
        this.count = size;
        this.ids = new int[size];
        for (int i =0; i< size; i++) {
            ids[i] = i;
        }
    }

    public void union(int p, int q) {
        int pId = ids[p];
        int qId = ids[q];

        for (int i =0; i < ids.length; i++) {
            if(ids[i] == pId)
                ids[i] = qId;
        }
        count--;
    }

    public int find(int p) {
        return ids[p];
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }

    public int[] getIds() {
        return ids;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(6);
        quickFind.union(0,1);
        quickFind.union(1, 2);
        quickFind.union(4, 5);
        quickFind.union(3, 2);

        System.out.println("Connected components >>> " + quickFind.getCount());
        System.out.println(Arrays.toString(quickFind.getIds()));
    }
}
