package labs.khobfa.union_find;

public class QuickUnion {

    private final int[] ids;
    int count;

    public QuickUnion(int nodes) {
        this.ids = new int[nodes];
        this.count = nodes;
        for(int i =0; i < nodes; i++) ids[i] = i;
    }

    private int root(int i) {
        while(i != ids[i]) i=ids[i];
        return i;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if(pRoot == qRoot) return;

        ids[pRoot] = qRoot;
        count--;
    }

    public int[] getIds() {
        return ids;
    }

    public int getCount() {
        return count;
    }
}
