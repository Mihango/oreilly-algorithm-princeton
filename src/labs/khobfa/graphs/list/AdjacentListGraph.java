package labs.khobfa.graphs.list;

import labs.khobfa.graphs.Graph;

import java.util.LinkedList;

public class AdjacentListGraph implements Graph {

    private final int vertices;
    private final boolean directed;
    private int edges = 0;
    private final LinkedList<Integer>[] adjacent;

    @SuppressWarnings("unchecked")
    public AdjacentListGraph(int vertices, boolean directed) {
        this.vertices = vertices;
        this.directed = directed;
        this.adjacent = new LinkedList[vertices];
        for (int i =0; i< adjacent.length; i++) {
            adjacent[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdge(int node, int node2) throws Exception {
        validate(node);
        validate(node2);

        adjacent[node].add(node2);
        if(!directed) {
            adjacent[node2].add(node);
        }
        edges++;
    }

    @Override
    public Iterable<Integer> adjacent(int vertex) throws Exception {
        validate(vertex);
        return adjacent[vertex];
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
