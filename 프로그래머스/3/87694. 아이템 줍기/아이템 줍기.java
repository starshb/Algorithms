import java.util.*;

class Solution {
    static final int[] moveX = new int[]{1, -1, 0, 0},
                        moveY = new int[]{0, 0, 1, -1};
    
    static class Node {
        int x;
        int y;
        int count;
        
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Boolean[][] roadway = new Boolean[102][102];
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int i = 0; i < rectangle.length; i++) {
            int[] nowRec = rectangle[i];
            
            for(int j = 0; j < 4; j++) nowRec[j] *= 2;
            
            for(int x = nowRec[0]; x <= nowRec[2]; x++) {
                for(int y = nowRec[1]; y <= nowRec[3]; y++) {
                    roadway[x][y] = (x == nowRec[0] || x == nowRec[2] ||
                                     y == nowRec[1] || y == nowRec[3]) && roadway[x][y] != Boolean.FALSE;   
                }
            }
            
        }
        
        Queue<Node> queue = new LinkedList<>();
        roadway[characterX][characterY] = false;
        queue.offer(new Node(characterX, characterY, 0));
        
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
            if(node.x == itemX && node.y == itemY && min > node.count) {
                min = node.count;
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int x = node.x + moveX[i], y = node.y + moveY[i];
                if(x < 2 || y < 2 || x > 100 || y > 100) continue;
                if(roadway[x][y] != Boolean.TRUE) continue;
                
                roadway[x][y] = false;
                queue.offer(new Node(x, y, node.count + 1));
            }
            
            
        }
        
        return min / 2;
    }
}