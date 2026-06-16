import java.util.*;
public class Main {
    static void bfs(int[][] adj, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int neighbor = 0; neighbor < v; neighbor++) {
                if (adj[node][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine().trim());

        int[][] adj = new int[v][v];
        for (int i = 0; i < v; i++) {
            String[] row = sc.nextLine().trim().split(" ");
            for (int j = 0; j < v; j++)
                adj[i][j] = Integer.parseInt(row[j]);
        }

        bfs(adj, v);
    }
}