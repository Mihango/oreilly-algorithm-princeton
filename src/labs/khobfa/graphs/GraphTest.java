package labs.khobfa.graphs;

import labs.khobfa.graphs.list.AdjacentListGraph;
import labs.khobfa.graphs.matrix.AdjacentMatrixGraph;

public class GraphTest {
    public static void main(String[] args) {
//        Graph graph = new AdjacentListGraph(6, false);
        Graph graph = new AdjacentMatrixGraph(6, false);
        try {
            graph.addEdge(0, 1);
            graph.addEdge(1, 2);
            graph.addEdge(1, 5);
            graph.addEdge(5, 2);
            graph.addEdge(4, 2);
            graph.addEdge(4, 3);
            graph.addEdge(4, 5);
            graph.addEdge(3, 2);

            graph.adjacent(1).forEach(i -> System.out.print(i + ", "));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
