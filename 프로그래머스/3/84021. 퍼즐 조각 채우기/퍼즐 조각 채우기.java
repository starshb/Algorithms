import java.util.*;

class Solution {
    List<List<Point>> t = new ArrayList<>();
    List<List<Point>> g = new ArrayList<>();
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        //규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 
        
        int len = game_board.length;
        
        //game_board 0, 1 바꿔주기
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(game_board[i][j]==1){
                    game_board[i][j] = 0;
                }
                else game_board[i][j] = 1;
            }
        }
        
        boolean[][] visited_t = new boolean[len][len];
        boolean[][] visited_g = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                //table에서 블록 추출
                if(table[i][j]==1 && !visited_t[i][j])
                    bfs(i, j, table, visited_t, t);
                    
                //game_board에서 빈공간 추출
                if(game_board[i][j]==1 && !visited_g[i][j])
                    bfs(i, j, game_board, visited_g, g);
            }
        }
        
        //table의 블록과 board 빈 공간의 블록을 회전하면서 비교해주기
        answer = compareBlock(t, g, answer);
        
        return answer;
    }
    
    public int compareBlock(List<List<Point>> table, List<List<Point>> board, int answer){
        int table_size = table.size();
        int board_size = board.size();
        
        boolean[] visited = new boolean[board_size];
        
        for(int i=0; i<table_size; i++){
            for(int j=0; j<board_size; j++){
                //일치하면
                if(visited[j] || table.get(i).size()!=board.get(j).size())
                    continue;
                if(isRotate(table.get(i), board.get(j))){
                    visited[j] = true; //블록으로 채워짐 
                    answer += board.get(j).size();
                    break;   
                }
               
            }
        }
        
        return answer;
    }
    
    public boolean isRotate(List<Point> table, List<Point> board){
        //오름차순 정렬
        Collections.sort(board);
        
        //90도씩 회전시켜보기. 0, 90, 180, 270
        for(int i=0; i<4; i++){
            //오름차순 정렬. table은 회전할때마다 다시 정렬해줌.
            Collections.sort(table);
            
            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;
            
            //회전하면서 좌표가 바뀌기 때문에, 다시 (0,0) 기준으로 세팅
            for(int j=0; j<table.size(); j++){
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }
            
            boolean check = true;
            //좌표 비교
            for(int j=0; j<board.size(); j++){
                if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                    check = false;
                    break;
                }
            }
            
            if(check){
                return true;
            }
            else{
               //90도 회전시키기. x, y -> y, -x
                for(int j=0; j<table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }         
        }
        
        return false;
    }
    
    public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list){
        
        visited[x][y] = true;
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        
        List<Point> sub_list = new ArrayList<>();
        sub_list.add(new Point(0, 0)); //(0,0) 기준으로 넣어줌
        
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx<0 || ny<0 || nx>=board.length || ny>=board.length) continue;
                
                if(!visited[nx][ny] && board[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    sub_list.add(new Point(nx-x, ny-y)); //(0, 0) 기준으로 넣기 때문에
                }
            }
        }
        
        list.add(sub_list);
    }
    
    static class Point implements Comparable<Point>{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Point o){
            int res = Integer.compare(this.x, o.x);
            if(res==0){
                res = Integer.compare(this.y, o.y);
            }
            return res;
        }
    }
}