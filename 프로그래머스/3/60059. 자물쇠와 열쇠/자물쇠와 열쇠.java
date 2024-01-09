import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int m = key.length;
        int n = lock.length;
        
        int len = n+m*2-2;
        int[][] map = new int[len][len];    // 확장시킨 배열
        
        /* 확장시킨 배열에 Lock 표시 */
        for(int i=m-1; i<m+n-1 ; i++){
            for(int j=m-1; j<m+n-1; j++){
                map[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        /* 4번 조사 */
        for(int i=0; i<4; i++){
            if(check(map, key, n)){
                return true;
            }
            rotate(key); // 시계방향 90도 회전
        }
        
        
        return false;
    }

    /* 키가 자물쇠에 맞는지 체크 */
    public static boolean check(int[][] map, int[][] key, int lockLen){
        int keyLen = key.length;
        int mapLen = map.length;
        for(int i=0; i<mapLen-keyLen+1; i++){
            for(int j=0; j<mapLen-keyLen+1; j++){
                
                /* map에 key를 더함 */
                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l] += key[k][l];
                    }
                }
                
                /* 자물쇠 부분이 전부 1이 됐는지 확인 */
                boolean flag = true;
                for(int k=keyLen-1; k<keyLen+lockLen-1; k++){
                    for(int l=keyLen-1; l<keyLen+lockLen-1; l++){
                        if(map[k][l] != 1){ // 1이 아니면 홈이 안 맞는 것임
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }
                
                if(flag) return true;   // 전부 1이였다면 true
                
                /* map을 원상 복귀 시킴 -> map에서 key를 뺌 */
                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l] -= key[k][l];
                    }
                }
                
            }
        }
        
        return false;
    }
    
    /* key 시계 방향 90도 회전 */
    public static void rotate(int[][] key){
        int len = key.length;
        int[][] temp = new int[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                temp[i][j] = key[len-j-1][i];
            }
        }
          
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                key[i][j] = temp[i][j];
            }
        }
        
    }
}