import java.util.*;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Graph {
    Map<String, List<String>> edges = new HashMap<String, List<String>>();

    public void addEdge(String src, String dest) {
        List<String> lstNeighbours = this.edges.get(src);
        if (lstNeighbours == null) {
            lstNeighbours = new ArrayList<String>();
            edges.put(src, lstNeighbours);
        }
        lstNeighbours.add(dest);
    }

    public List<String> getNeighbours(String vertex) {
        List<String> lstNeighbours = edges.get(vertex);
        if (lstNeighbours == null)
            return Collections.emptyList();
        else
            return Collections.unmodifiableList(lstNeighbours);
    }

    public Map<String, String> searchBsf(Graph graph, String start, String end) {
        Set<String> visited = new HashSet<String>();
        Map<String, String> previous = new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visited.add(start);
        previous.put(start, null);
        while (!queue.isEmpty()) {
            String vertex = queue.remove();
            graph.getNeighbours(vertex).stream()
                .filter(v -> !visited.contains(v))
                .forEach(v -> {
                    visited.add(v);
                    previous.put(v, vertex);
                    if (v.equals(end)) {
                        queue.clear();
                    } else {
                        queue.add(v);
                    }
                });
        }
        return previous;
    }

    public Map<String, String> searchDsf(Graph graph, String start, String end) {
        Set<String> visited = new HashSet<String>();
        Map<String, String> previous = new HashMap<String, String>();
        Stack<String> stack = new Stack();
        stack.push(start);
        visited.add(start);
        previous.put(start, null);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            graph.getNeighbours(vertex).stream()
                    .filter(v -> !visited.contains(v))
                    .forEach(v -> {
                        visited.add(v);
                        previous.put(v, vertex);
                        if (v.equals(end)) {
                            stack.clear();
                        } else
                            stack.push(v);
                    });
        }
        return previous;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "A");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "A");
        graph.addEdge("D", "C");
        graph.addEdge("E", "B");
        graph.addEdge("F", "B");

        String start = "A";
        String end = "F";
        Map<String, String> traces = graph.searchBsf(graph, start, end);

        while (traces.get(end) != null) {
            end = traces.get(end);
            System.out.println(end);
        }
    }
}
