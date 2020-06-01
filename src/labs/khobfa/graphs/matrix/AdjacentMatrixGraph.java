package labs.khobfa.graphs.matrix;

import labs.khobfa.graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacentMatrixGraph implements Graph {

    private int edges;
    private final boolean directed;
    private final int vertices;
    private final int[][] data;

    public AdjacentMatrixGraph(int size, boolean directed) {
        this.vertices = size;
        this.directed = directed;
        this.data = new int[this.vertices][this.vertices];
    }

    @Override
    public void addEdge(int node, int node2) throws Exception {
        validate(node);
        validate(node2);

        data[node][node2] = 1;

        if(!directed) {
            data[node2][node] = 1;
        }
        edges++;
    }

    @Override
    public Iterable<Integer> adjacent(int vertex) throws Exception {
        validate(vertex);

        List<Integer> result = new ArrayList<>();
        int[] adj = data[vertex];
        for (int i = 0; i < data.length; i++) {
            if (adj[i] == 1)
                result.add(i);
        }
        return result;
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    private void validate(int vertex) throws Exception {
        if(vertex >= 0 && vertex < this.vertices) return;
        throw new Exception("Not valid node");
    }
}
