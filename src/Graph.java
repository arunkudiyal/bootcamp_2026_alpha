import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    int V; int[][] graph;
    Graph(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        dfsUtil(start, visited);
    }

    public void dfsUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int v = 0; v < V; v++) {
            if(graph[start][v] == 1 && !visited[v]) {
                dfsUtil(v, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.graph = new int[][]{
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };
        g.dfs(0);
        System.out.println();
    }
}
