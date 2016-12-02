import java.util.*;

/**
 * Created by qale0001 on 01/12/2016.
 */
public class DijkstraGraph {

    public static void main(String[] args) {
        WeightGraph graph = new WeightGraph();
        graph.add2ways("a", "b", 7);
        graph.add2ways("a", "c", 9);
        graph.add2ways("a", "f", 14);
        graph.add2ways("b", "c", 10);
        graph.add2ways("b", "d", 15);
        graph.add2ways("c", "d", 11);
        graph.add2ways("d", "f", 2);
        graph.add2ways("d", "e", 6);
        graph.add2ways("e", "f", 9);

        Map<String, String> shortestPath = new Dijkstra().findPath(graph, "a", "e");


        /* EX2
        graph.add("1", "6", 14);
        graph.add("6", "1", 14);

        graph.add("1", "3", 9);
        graph.add("3", "1", 9);

        graph.add("1", "2", 7);
        graph.add("2", "1", 7);

        graph.add("6", "5", 7);
        graph.add("5", "6", 7);

        graph.add("3", "6", 2);
        graph.add("6", "3", 2);

        graph.add("2", "3", 10);
        graph.add("3", "2", 10);

        graph.add("2", "4", 15);
        graph.add("4", "2", 15);

        graph.add("3", "4", 11);
        graph.add("4", "2", 11);

        graph.add("4", "5", 6);
        graph.add("5", "4", 6);


        // 1 6 14
        // 1 3 9
        // 1 2 7
        // 6 5 9
        // 3 6 2
        // 2 3 10
        // 2 4 15
        // 3 4 11
        // 4 5 6

        Map<String, String> shortestPath = new Dijkstra().findPath(graph, "1", "5");
        */
        String trace = shortestPath.get("e");
        System.out.println(trace);
        while (trace != null) {
            trace = shortestPath.get(trace);
            System.out.println(trace);
        }
    }
}
