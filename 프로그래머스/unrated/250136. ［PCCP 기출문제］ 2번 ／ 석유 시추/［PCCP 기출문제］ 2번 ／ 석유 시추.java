import java.util.*;  
  
class Solution {  
  
    // 방향을 나타내는 배열  
    int[] dx = {-1, 0, 1, 0};  
    int[] dy = {0, 1, 0, -1};  
    int n, m; // 땅의 세로 길이와 가로 길이  
    int[][] land; // 땅의 정보를 담은 배열  
    int[][] oil; // 석유 덩어리의 ID를 저장하는 배열  
    boolean[][] visited; // 방문 여부를 저장하는 배열  
  
    public int solution(int[][] land) {  
        this.land = land;  
        this.n = land.length;  
        this.m = land[0].length;  
        this.oil = new int[n][m];  
        this.visited = new boolean[n][m];  
  
        int oilId = 0; // 석유 덩어리의 ID        
        Map<Integer, Integer> oilSize = new HashMap<>(); // 각 석유 덩어리의 크기를 저장하는 맵  
  
        // 모든 칸에 대해 BFS를 수행하여 석유 덩어리를 찾고 그 크기를 계산  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < m; j++) {  
                if (land[i][j] == 1 && !visited[i][j]) {  
                    int size = bfs(i, j, oilId);  
                    oilSize.put(oilId, size);  
                    oilId++;  
                }  
            }  
        }  
  
        int[] oilSum = new int[m]; // 각 열에서 뽑을 수 있는 석유의 총량을 저장하는 배열  
        // 각 열에 대해 그 열을 관통하는 석유 덩어리의 크기를 합산  
        for (int j = 0; j < m; j++) {  
            Set<Integer> oilSet = new HashSet<>();  
            for (int i = 0; i < n; i++) {  
                if (land[i][j] == 1) {  
                    oilSet.add(oil[i][j]);  
                }  
            }  
            for (int id : oilSet) {  
                oilSum[j] += oilSize.get(id);  
            }  
        }  
  
        // 가장 많은 석유를 뽑을 수 있는 열을 찾아 그 석유의 총량을 반환  
        return Arrays.stream(oilSum).max().getAsInt();  
    }  
  
    // BFS를 수행하여 석유 덩어리를 찾고 그 크기를 반환하는 메서드  
    private int bfs(int x, int y, int oilId) {  
        Queue<int[]> queue = new LinkedList<>();  
        queue.offer(new int[]{x, y});  
        visited[x][y] = true;  
        oil[x][y] = oilId;  
        int size = 1;  
  
        while (!queue.isEmpty()) {  
            int[] current = queue.poll();  
            for (int i = 0; i < 4; i++) {  
                int nx = current[0] + dx[i];  
                int ny = current[1] + dy[i];  
                // 다음 위치가 땅 내부에 있고 석유가 있으며 아직 방문하지 않았다면  
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1  
                    && !visited[nx][ny]) {  
                    queue.offer(new int[]{nx, ny});  
                    visited[nx][ny] = true;  
                    oil[nx][ny] = oilId;  
                    size++;  
                }  
            }  
        }  
  
        return size; // 석유 덩어리의 크기 반환  
    }  
}