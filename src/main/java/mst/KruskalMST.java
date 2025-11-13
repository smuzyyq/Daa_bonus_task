package mst;

import java.util.*;

public class KruskalMST {

    public static List<Edge> buildMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(graph.edges);

        DisjointSet ds = new DisjointSet(graph.V);

        for (Edge edge : graph.edges) {
            int rootU = ds.find(edge.src);
            int rootV = ds.find(edge.dest);
            if (rootU != rootV) {
                result.add(edge);
                ds.union(rootU, rootV);
            }
        }
        return result;
    }

    public static void removeEdge(List<Edge> mst, int indexToRemove) {
        mst.remove(indexToRemove);
    }

    public static void showComponents(List<Edge> mst, int V) {
        DisjointSet ds = new DisjointSet(V);
        for (Edge e : mst) ds.union(e.src, e.dest);

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < V; i++) {
            int root = ds.find(i);
            components.putIfAbsent(root, new ArrayList<>());
            components.get(root).add(i);
        }

        System.out.println("Components after edge removal:");
        for (List<Integer> comp : components.values())
            System.out.println(comp);
    }

    public static Edge findReplacementEdge(Graph graph, List<Edge> mst) {
        // Define components
        DisjointSet ds = new DisjointSet(graph.V);
        for (Edge e : mst) ds.union(e.src, e.dest);

        Edge replacement = null;
        int minWeight = Integer.MAX_VALUE;

        for (Edge e : graph.edges) {
            int rootU = ds.find(e.src);
            int rootV = ds.find(e.dest);

            if (rootU != rootV && e.weight < minWeight) {
                minWeight = e.weight;
                replacement = e;
            }
        }
        return replacement;
    }
}
