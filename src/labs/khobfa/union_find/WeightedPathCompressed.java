package labs.khobfa.union_find;

public class WeightedPathCompressed {

    private final int[] ids;
    private final int[] weight;
    private int count;

    public WeightedPathCompressed(int size) {
        this.ids = new int[size];
        this.weight = new int[size];
        this.count = size;
        for (int i = 0; i < size; i++) {
            ids[i] = i;
            weight[i] = 1;
        }
    }

    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);

        if (pRoot == qRoot) return;

        if (weight[pRoot] < weight[qRoot]) {
            ids[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        } else {
            ids[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        }
        count--;
    }

    private int findRoot(int p) {
        int initP = p;
        while (p != ids[p])
            p = ids[p];

        while (initP != p) {
            System.out.println("While update called >>> " + initP + " >>>> " + ids[initP]);
            int tmp = ids[initP];
            ids[initP] = p;
            initP = tmp;
        }

        return p;
    }

    public int[] getIds() {
        return ids;
    }

    public int[] getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }
}
