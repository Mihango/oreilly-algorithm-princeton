package labs.khobfa.graphs;

import labs.khobfa.graphs.list.AdjacentListGraph;
import labs.khobfa.graphs.list.ListDFS;
import labs.khobfa.graphs.matrix.AdjacentMatrixGraph;
import labs.khobfa.graphs.matrix.MatrixDFS;

import java.util.Stack;

public class GraphTest {
    public static void main(String[] args) {
//        Graph graph = new AdjacentListGraph(6, false);
        Graph graph = new AdjacentMatrixGraph(6, false);
        try {
            graph.addEdge(0, 1);
            graph.addEdge(1, 2);
            graph.addEdge(3, 2);
            graph.addEdge(1, 5);
            graph.addEdge(5, 2);
            graph.addEdge(4, 2);
            graph.addEdge(4, 3);
            graph.addEdge(4, 5);

            graph.adjacent(4).forEach(i -> System.out.print(i + ", "));

//            DFS dfs = new ListDFS(graph, 0);
            DFS dfs = new MatrixDFS(graph, 0);

            Stack<Integer> stack = (Stack<Integer>) dfs.pathTo(3);
            while (!stack.empty()) {
                System.out.print(" --> " + stack.pop());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
