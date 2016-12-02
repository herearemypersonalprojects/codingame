import java.util.*;

/**
 * Created by qale0001 on 02/12/2016.
 */
public class WeightGraph {
    Map<String, List<String>> adjacentLabels = new HashMap<>();
    Map<String, Integer> adjacentWeights = new HashMap<>();

    private String getKey(String start, String end) {
        return start + ":" + end;
    }

    public void add2ways(String start, String end, Integer value) {
        this.add(start, end, value);
        this.add(end, start, value);
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
