import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int N;
    int E;
    int[][] matrix;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        N = n;
        E = fares.length;
        matrix = new int[n][n];

        for (int i = 0; i < E; i++) {
            int u = fares[i][0] - 1;
            int v = fares[i][1] - 1;
            int cost = fares[i][2];
            matrix[u][v] = cost;
            matrix[v][u] = cost;
        }

        int[] together = dijkstra(s - 1);
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int[] alone = dijkstra(i);
            int cost = together[i] + alone[a - 1] + alone[b - 1];
            if(cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new int[] {0, start});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[1];
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            for (int v = 0; v < N; v++) {
                if(matrix[u][v] == 0) {
                    continue;
                }
                if (distance[u] + matrix[u][v] < distance[v]) {
                    distance[v] = distance[u] + matrix[u][v];
                    pq.add(new int[]{distance[v], v});
                }
            }
        }

        return distance;
    }
}