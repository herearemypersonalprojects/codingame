import java.util.*;

/**
 * Created by qale0001 on 02/12/2016.
 */
public class Dijkstra {
    public Map<String, String> findPath(WeightGraph graph, String start, String end) {
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
