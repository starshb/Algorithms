	import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M, map[][];
    static int dp[][][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[750][750];   // row, col 최대 범위 : 750
        dp = new int[750][750][4]; // 동, 서, 남, 북 방향 4개
        
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }          
        
        // 크기가 1x1 일 경우
        if (N == 1 && M == 1) {
            System.out.println(map[0][0]);
            return;
        }
        
        // 최대 다이아몬드 모양 찾기
        int maxSize = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1) {
                    for (int d=0; d<4; d++) {
                        dp[i][j][d] = getSize(i, j, d);
                    }
                    
                    // ↖(2) ↗(3) 변 길이가 maxSize를 넘는 경우 
                    if (dp[i][j][2] > maxSize && dp[i][j][3] > maxSize) {
                        int len = Math.min(dp[i][j][2], dp[i][j][3])-1;
                        
                        // 최대길이부터 maxSize 까지 다이아몬드 모양이 되는지 확인
                        for (int tmpLen=len; tmpLen>=maxSize; tmpLen--) {
                            if (i-(2*tmpLen) < 0) continue;
                            
                            // ↙(0) ↘(1) 변 길이가 tmpLen를 넘었을 경우
                            if (dp[i-(2*tmpLen)][j][0] > tmpLen && dp[i-(2*tmpLen)][j][1] > tmpLen) {
                                maxSize = tmpLen+1;
                                break;
                            }
                        }
                    }
                }
            }
        }        
        
        
        System.out.println(maxSize);
    }
    
    // 0: 위 꼭짓점 기준 왼쪽 아래
    // 1: 위 꼭짓점 기준 오른쪽 아래
    // 2: 아래 꼭짓점 기준 왼쪽 위
    // 3: 아래 꼭짓점 기준 오른쪽 위
    public static int getSize(int x, int y, int d) {
        int size = 0;
        
        int dx = 0;
        int dy = 0;
        
        while (true) {
            int nx = x + dx;
            int ny = y + dy;
            
            if (d == 0) {        // ↙
                dx++;
                dy--;
            } else if (d == 1) { // ↘
                dx++;
                dy++;
            } else if (d == 2) { // ↖
                dx--;
                dy--;
            } else if (d == 3) { // ↗
                dx--;
                dy++;
            }
            
            // 범위를 벗어나거나 값이 0인 경우
            if (nx < 0 || ny < 0 || nx > N-1 || ny > M-1 || map[nx][ny] == 0) break;
            size++;
        }
        
        return size;
    }
}