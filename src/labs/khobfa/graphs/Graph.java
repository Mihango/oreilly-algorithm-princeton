package labs.khobfa.graphs;

public interface Graph {
    void addEdge(int node, int node2) throws Exception;
    Iterable<Integer> adjacent(int vertex) throws Exception;
    int vertices();
    int edges();
    void validate(int x) throws Exception;
}
