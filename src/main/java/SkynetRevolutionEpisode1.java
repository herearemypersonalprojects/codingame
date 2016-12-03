import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SkynetRevolutionEpisode1 {
    static class Graph {
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
                            System.err.println("Debug messages..." + neighbour);
                            break;
                        } else {
                            queue.add(neighbour);
                        }
                    }
                }
            }

            return previous;
        }
    }

    private static String getSeverLink(int N, Graph graph, Set<String> gateways, String si) {
        Map<String, String> trace = graph.searchBsf(si, gateways);
        String gateway = gateways.stream()
                .filter(g -> trace.get(g) != null)
                .findFirst()
                .get();
        if (gateway == null)
            return null;
        String previous = trace.get(gateway);
        graph.removeEdge(previous, gateway);
        return previous + " " + gateway;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        Graph graph = new Graph();

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            graph.add2ways(String.valueOf(N1), String.valueOf(N2));
        }

        Set<String> gateways = new HashSet<>();
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways.add(String.valueOf(EI));
        }

        // game loop
        while (!gateways.isEmpty()) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            String severedLink = getSeverLink(N, graph, gateways, String.valueOf(SI));
            if (severedLink == null)
                break;

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println(severedLink);
        }
    }
}