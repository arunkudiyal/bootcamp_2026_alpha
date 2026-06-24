import java.util.*;

class DetectCycle {
    List<List<Integer>> graph = new ArrayList<>();

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public boolean dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;
        // neighbors
        for(int i=0; i < graph.get(node).size(); i++) {
            int neighbor = graph.get(node).get(i);
            if(!visited[neighbor]) {
                if(dfs(neighbor, node, visited)) return true;
            }
            else if(parent != neighbor) return true;
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        // add vertices
        for(int i=0; i < V; i++) {
            graph.add(new ArrayList<>(i));
        }
        // add edges
        for(int i=0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
        // connected graph
        for(int i=0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle obj = new DetectCycle();
        int V = 5;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{3, 1},
                new int[]{3, 2},
                new int[]{4, 3}
        };

        System.out.println(obj.isCycle(V, edges));
    }
}