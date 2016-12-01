import java.util.*;

/**
 * Created by qale0001 on 01/12/2016.
 */
public class DijkstraGraph {

    private static class Graph {
        Map<String, List<String>> adjacentLabels = new HashMap<>();
        Map<String, Integer> adjacentWeights = new HashMap<>();

        private String getKey(String start, String end) {
            return start + ":" + end;
        }

        public void add(String start, String end, Integer value) {
            List<String> neighbours = adjacentLabels.get(start);
            if (neighbours == null) {
                neighbours = new ArrayList();
                adjacentLabels.put(start, neighbours);
            }
            neighbours.add(end);
            adjacentWeights.put(getKey(start, end), value);
        }

        public List<String> getNeighbours(String vertex) {
            List<String> neighbours = adjacentLabels.get(vertex);
            if (neighbours.isEmpty()) {
                return Collections.emptyList();
            } else {
                return neighbours;
            }
        }

        public int getWeight(String start, String end) {
            Integer weight = adjacentWeights.get(getKey(start, end));
            if (weight == null) {
                return 0;
            } else {
                return weight;
            }
        }
    }

    private static class Dijkstra {
        public Map<String, String> findPath(Graph graph, String start, String end) {
            Map<String, Integer> labels = new HashMap<>();
            Queue<String> queue = new LinkedList<>();
            Map<String, String> previous = new HashMap<>();
            Set<String> visited = new HashSet<>();

            queue.add(start);
            previous.put(start, null);
            labels.put(start, 0);

            while (!queue.isEmpty()) {
                String vertex = queue.remove();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);

                    graph.getNeighbours(vertex).stream()
                            .forEach(v -> {
                                int weight = graph.getWeight(vertex, v);

                                if (labels.get(v) == null || labels.get(vertex) + weight < labels.get(v)) {
                                    labels.put(v, labels.get(vertex) + weight);
                                    previous.put(v, vertex);
                                    queue.add(v);
                                }


                            });
                }
            }
            return previous;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
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

        String trace = shortestPath.get("5");
        System.out.println(trace);
        while (trace != null) {
            trace = shortestPath.get(trace);
            System.out.println(trace);
        }
    }
}
