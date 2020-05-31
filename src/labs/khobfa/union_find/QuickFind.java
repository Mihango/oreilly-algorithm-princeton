package labs.khobfa.union_find;

public class QuickFind {
    private final int[] ids;
    private int count = 0;

    public QuickFind(int vertices) {
        this.ids = new int[vertices];
        this.count = vertices;
        for (int i =0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    public int find(int v) {
        return ids[v];
    }

    public boolean isConnected(int v, int w) {
        return ids[v] == ids[w];
    }

    public void union(int v, int w) {
        int id1 = ids[v];
        int id2 = ids[w];

        if(id1 == id2) return;

        for (int i =0; i< ids.length; i++) {
            if(ids[i] == id1)
                ids[i] = id2;
        }

        count--;
    }

    public int getCount() {
        return this.count;
    }

    public int[] getIds() {
        return ids;
    }
}
