package mst;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 0, 4);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(3, 4, 3);
        g.addEdge(5, 4, 3);

        // Build MST
        List<Edge> mst = KruskalMST.buildMST(g);
        System.out.println("Initial MST:");
        mst.forEach(System.out::println);

        // Delete 1 edge
        KruskalMST.removeEdge(mst, 2);
        System.out.println("\nMST after removing one edge:");
        mst.forEach(System.out::println);

        // Show components
        KruskalMST.showComponents(mst, g.V);

        // Find replacement
        Edge replacement = KruskalMST.findReplacementEdge(g, mst);
        if (replacement != null) {
            System.out.println("\nReplacement edge found: " + replacement);
            mst.add(replacement);
            System.out.println("\nNew MST:");
            mst.forEach(System.out::println);
        } else {
            System.out.println("\nNo replacement edge found!");
        }
    }
}
