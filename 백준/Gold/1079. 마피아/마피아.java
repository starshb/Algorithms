import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] score = new int[N];             //유죄 지수를 저장하기 위한 배열
        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(input[i]);
        }

        int[][] R = new int[N][N];            //유죄 지수를 바꿀 때 이용하는 값 저장
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");

            for(int j=0; j<N; j++) {
                R[i][j] = Integer.parseInt(input[j]);
            }
        }

        int mafia = Integer.parseInt(br.readLine());

        dfs(0, mafia, N, R, score, new boolean[N]);

        System.out.println(ans);
    }

    public static void dfs(int time, int mafia, int cnt, int[][] R, int[] score, boolean[] visited) {
        if(cnt%2==1) {                //낮일 때
            int max = -1;
            int max_idx = -1;

            for(int i=0; i<N; i++) {
                if(!visited[i]) {
                    if(max < score[i]) {
                        max = score[i];
                        max_idx = i;
                    }
                }
            }

            if(max_idx==mafia) {            //마피아를 죽이면 시민 승으로 끝
                ans = Math.max(ans, time);
                return;
            }

            visited[max_idx] = true;

            dfs(time, mafia, cnt-1, R, score, visited);

            visited[max_idx] = false;
        }

        else {                  //밤일 때
            if(cnt==2) {                      //마피아 1명, 시민 1명이 남았으면 마피아 승으로 끝
                ans = Math.max(ans, time+1);
                return;
            }

            for(int i=0; i<N; i++) {
                if(i==mafia) continue;

                if(!visited[i]) {
                    visited[i] = true;

                    for(int j=0; j<N; j++) {        //유죄 지수 변경
                        score[j] += R[i][j];
                    }

                    dfs(time+1, mafia, cnt-1, R, score, visited);

                    for(int j=0; j<N; j++) {        //유죄 지수 회복
                        score[j] -= R[i][j];
                    }

                    visited[i] = false;
                }
            }
        }
    }
}