package labs.khobfa.graphs.matrix;

import labs.khobfa.graphs.DFS;
import labs.khobfa.graphs.Graph;

import java.util.List;

public class MatrixDFS implements DFS {

    private int edgeTo[];
    private boolean visited[];

    public MatrixDFS(Graph graph, int source) {
        this.edgeTo = new int[graph.vertices()];
        this.visited = new boolean[graph.vertices()];
        dfs(graph, source);
    }

    @Override
    public void dfs(Graph graph, int source) {
        visited[source] = true;

        List<Integer> adj;
        try {
            adj = (List<Integer>) graph.adjacent(source);
            for (int node = 0; node < adj.size(); node++) {
                if (!visited[node]) {
                    dfs(graph, node);
                    edgeTo[node] = source;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
