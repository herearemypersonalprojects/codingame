import java.util.Map;

/**
 * Created by qale0001 on 01/12/2016.
 */
public class DijkstraMatrix {

    public static void main(String[] args) {
        int n = 6;
        String[] lines = new String[n];
        lines[0] = "0 7 9 0 0 14";
        lines[1] = "7 0 10 15 0 0";
        lines[2] = "9 10 0 11 0 0";
        lines[3] = "0 15 11 0 6 0";
        lines[4] = "0 0 0 6 0 9";
        lines[5] = "14 7 9 2 9 0";

        WeightGraph graph = new WeightGraph();

        for (int i = 0; i < n; i++) {
            String[] p = lines[i].split(" ");
            for (int j = 0; j < p.length; j++) {
                String vertex1 = String.valueOf(i);
                String vertex2 = String.valueOf(j);
                Integer value = Integer.valueOf(p[j]);
                graph.add2ways(vertex1, vertex2, value);
            }
        }

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
        String trace = shortestPath.get("e");
        System.out.println(trace);
        while (trace != null) {
            trace = shortestPath.get(trace);
            System.out.println(trace);
        }
    }
}
