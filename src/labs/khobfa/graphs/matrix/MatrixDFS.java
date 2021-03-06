package labs.khobfa.graphs.matrix;

import labs.khobfa.graphs.DFS;
import labs.khobfa.graphs.Graph;

import java.util.Stack;

public class MatrixDFS implements DFS {
    private final int[] edgeTo;
    private final boolean[] visited;
    private final int source;

    public MatrixDFS(Graph graph, int source) throws Exception {
        this.edgeTo = new int[graph.vertices()];
        this.visited = new boolean[graph.vertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(Graph graph, int source) throws Exception {
        graph.validate(source);
        visited[source] = true;

        for (int i : graph.adjacent(source)) {
            if(!visited[i]) {
                edgeTo[i] = source;
                dfs(graph, i);
            }
        }
    }

    @Override
    public Iterable<Integer> pathTo(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (node != source) {
            stack.push(edgeTo[node]);
            node = edgeTo[node];
        }
        return stack;
    }
}
