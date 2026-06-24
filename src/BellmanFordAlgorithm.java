import java.util.*;

public class BellmanFordAlgorithm {
    int V;
    List<List<int[]>> graph;

    public BellmanFordAlgorithm(int vertices) {
        V = vertices;
        graph = new ArrayList<>();
        // add vertices to list
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<>());
    }

    public void addEdge(int u, int v, int weight) {
        graph.get(u).add(new int[]{v, weight});
    }

    public void bellmanFordAlgorithm(List<List<int[]>> graph, int start) {}

    public static void main(String[] args) {
        BellmanFordAlgorithm obj = new BellmanFordAlgorithm(5);

        obj.addEdge(0, 1, -1);
        obj.addEdge(0, 2, 4);
        obj.addEdge(1, 2, 3);
        obj.addEdge(1, 3, 2);
        obj.addEdge(1, 4, 2);
        obj.addEdge(3, 1, 1);
        obj.addEdge(3, 2, 5);
        obj.addEdge(4, 3, -3);

        int source = 0;
        obj.bellmanFordAlgorithm(obj.graph, source);
    }
}
