package labs.khobfa.union_find;

public class WeightedQuickUnion {

    private final int[] ids; // roots
    private final int[] weight; // showing depth of root
    private int count; // number of components

    public WeightedQuickUnion(int size) {
        this.ids = new int[size];
        this.weight = new int[size];
        this.count = size;
        for(int i = 0; i < size; i++) {
            ids[i] = i;
            weight[i] = 1;
        }
    }

    public int[] getIds() {
        return ids;
    }

    public int getCount() {
        return count;
    }

    public int[] getWeight() {
        return weight;
    }

    public int findRoot(int p) {
        while(p != ids[p]) p = ids[p];
        return p;
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        if(weight[pRoot] < weight[qRoot]) {
            ids[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        } else {
            ids[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        }
        count--;
    }
}
