import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            // explore the neighbors of 'u'
            for(int v = 0; v < V; v++) {
                if(graph[u][v] == 1 && !visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
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
        System.out.println();                   // 0 1 3 4 2

        g.bfs(0);                           // 0 1 2 3 4
        System.out.println();

        g.bfs(1);                           // 0 1 2 3 4
        System.out.println();
    }
}
