import java.util.*;
class Pos {
    int x, y;
    int level;
    Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
class Solution {
    public char[][] map;
    public boolean[][] visited;
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public Pos getPos(int index, Pos now) {
        int x = now.x , y = now.y;
        int ix = dx[index];
        int iy = dy[index];
        while(x + ix >= 0 && x + ix < map.length 
              && y + iy >= 0 && y + iy < map[0].length
                && map[x + ix][y + iy] != 'D') 
        {
            x += ix;
            y += iy;
        }

        return new Pos(x, y, now.level + 1);
    }
    public int bfs(Pos start, Pos goal) {
        Queue<Pos> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(start);
        while(!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;
            if(x == goal.x && y == goal.y)
                return level;
            for(int i = 0; i < 4; i++) {
                Pos next = getPos(i, now);            
                if(!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }
    public int solution(String[] board) {
        int answer = 0;
        map = new char[board.length][board[0].length()];
        visited = new boolean[map.length][map[0].length];
        Pos start = null;
        Pos goal = null;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R')
                    start = new Pos(i, j, 0);
                if(map[i][j] == 'G')
                    goal = new Pos(i, j, 0);
            }
        }
        answer = bfs(start, goal);
        return answer;
    }
}