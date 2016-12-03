import java.util.*;

/**
 * Created by qale0001 on 30/11/2016.
 */
public class Graph {
    Map<String, List<String>> edges = new HashMap<String, List<String>>();

    public void add2ways(String start, String end) {
        this.addEdge(start, end);
        this.addEdge(end, start);
    }

    public void addEdge(String src, String dest) {
        List<String> lstNeighbours = this.edges.get(src);
        if (lstNeighbours == null) {
            lstNeighbours = new ArrayList<String>();
            edges.put(src, lstNeighbours);
        }
        lstNeighbours.add(dest);
    }

    public void remove2way(String src, String dest) {
        removeEdge(src, dest);
        removeEdge(dest, src);
    }

    public void removeEdge(String src, String dest) {
        List<String> lstNeighbours = this.edges.get(src);
        if (lstNeighbours != null) {
            lstNeighbours.remove(dest);
        }
    }

    public List<String> getNeighbours(String vertex) {
        List<String> lstNeighbours = edges.get(vertex);
        if (lstNeighbours == null)
            return Collections.emptyList();
        else
            return Collections.unmodifiableList(lstNeighbours);
    }

    public Map<String, String> searchBsf(String start, Set<String> gateways) {
        Set<String> visited = new HashSet<String>();
        Map<String, String> previous = new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visited.add(start);
        previous.put(start, null);
        while (!queue.isEmpty()) {
            String vertex = queue.remove();
            for (String neighbour : this.getNeighbours(vertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    previous.put(neighbour, vertex);
                    if (gateways.contains(neighbour)) {
                        queue.clear();
                        break;
                    } else {
                        queue.add(neighbour);
                    }
                }
            }
        }

        return previous;
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
            for (String neighbour : this.getNeighbours(vertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    previous.put(neighbour, vertex);
                    if (end.equals(neighbour)) {
                        queue.clear();
                        break;
                    } else {
                        queue.add(neighbour);
                    }
                }
            }
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
            for (String neighbour : this.getNeighbours(vertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    previous.put(neighbour, vertex);
                    if (end.equals(neighbour)) {
                        stack.clear();
                        break;
                    } else {
                        stack.add(neighbour);
                    }
                }
            }
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
