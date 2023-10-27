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
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public int bfs(int startX, int startY, int H, int W, int EndX, int EndY) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(startX, startY, 0));
        visited[startX][startY] = true;
        while(!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;
            if(x == EndX && y == EndY)
            {
                return level;
            }
            
            for(int i = 0; i < 4; i++) {
                int nowX = x + dx[i];
                int nowY = y + dy[i];
                if(nowX < 0 || nowX >= H || nowY < 0 || nowY >= W)
                    continue;
                if(!visited[nowX][nowY] && map[nowX][nowY] != 'X') 
                {
                    q.add(new Pos(nowX, nowY, level + 1));
                    visited[nowX][nowY] = true;
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        Pos startPos = null;
        Pos leverPos = null;
        Pos endPos = null;
        for(int i = 0; i < maps.length; i++) {            
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S')
                    startPos = new Pos(i, j, 0);
                if(maps[i].charAt(j) == 'L')
                    leverPos = new Pos(i, j, 0);
                if(maps[i].charAt(j) == 'E')
                    endPos = new Pos(i, j, 0);
                map[i][j] = maps[i].charAt(j);
            }
        }
        answer = bfs(startPos.x, startPos.y, maps.length, maps[0].length(), leverPos.x, leverPos.y);
        if(answer > -1)
        {
            visited = new boolean[map.length][map[0].length];
            
            int temp = bfs(leverPos.x, leverPos.y, maps.length, maps[0].length(), endPos.x, endPos.y);
            if(temp == -1)
                answer = -1;
            else
                answer += temp;
        }
        return answer;
    }
}