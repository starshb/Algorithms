import java.io.*;
import java.util.*;
 
public class Main {
 
    static int n, m;
    static char[][] board;
    static Node start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
 
    public static void main(String[] args) throws IOException {
 
        //입력
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        board = new char[n][m];
        for(int i = 0; i < n; i++) {
            str = bf.readLine();
            for(int j = 0; j < m; j++) {
                char c = str.charAt(j);
                board[i][j] = c;
                if(c == '0') start = new Node(i, j, 0, 0);
            }
        }
        //입력 끝
        System.out.println(bfs());
    }   
 
    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][64]; //열쇠 가지고 방문 여부 체크. 
        q.offer(start);
        visited[start.x][start.y][0] = true;
 
        while(!q.isEmpty()) {
            Node current = q.poll();
            if(board[current.x][current.y] == '1') return current.cost;
 
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
 
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny][current.key] || board[nx][ny] == '#') continue;
                
                if(board[nx][ny] >= 'a' && board[nx][ny] <= 'f') { //열쇠
                    int next_key = 1 << (board[nx][ny] - 'a');
                    next_key = current.key | next_key;
                    visited[nx][ny][next_key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, next_key));
                }
                else if(board[nx][ny] >= 'A' && board[nx][ny] <= 'F') { //문
                    if((current.key & 1 << (board[nx][ny] - 'A')) == (int)Math.pow(2, board[nx][ny] - 'A')) { //해당 비트가 켜져있는지 확인
                        visited[nx][ny][current.key] = true;
                        q.offer(new Node(nx, ny, current.cost + 1, current.key));
                    }
                } else {
                    visited[nx][ny][current.key] = true;
                    q.offer(new Node(nx, ny, current.cost + 1, current.key));
                }
            }
        }
        return -1;
    }
 
    public static class Node {
        int x, y, cost, key;
 
        public Node(int x, int y, int cost, int key) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.key = key;
        }
    }
}
