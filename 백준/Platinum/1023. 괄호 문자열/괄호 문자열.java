import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()) + 1;
        //길이가 N개일 때 '(', ')'만 사용하여 만들 수 있는 문자열 개수
        long[] combinationCnt = new long[N+1];
        //ㄴㄴ괄호 문자열에 대한 조합 DP[i][j]
        long[][] DP = new long[N+1][N+1];
        combinationCnt[0] = 1;
        //문자열 개수 및  DP[i][0]값 초기화
        for(int i=1;i<=N;i++){
            combinationCnt[i] = combinationCnt[i-1] * 2;
            DP[i][0] = 1;
        }

        //점화식을 이용한 DP[i][j] 메모이제이션 진행
        for(int i=1;i<=N;i++) {
            DP[0][i] = DP[1][i - 1] + combinationCnt[i - 1];
            for (int j = 1; j <= N - i; j++) {
                DP[j][i] = DP[j - 1][i - 1] + DP[j + 1][i - 1];
            }
        }

        //ㄴㄴ괄호 문자열 총 개수보다 K가 클 때, -> K번째 문자열을 만들지 못할 때
        if((N % 2 == 1 && K > combinationCnt[N]) || (N % 2 == 0 && K > DP[0][N])){
            bw.write("-1");
        }else{
            StringBuilder sb = new StringBuilder();
            //현재 '(', ')'을 삽입한 개수
            int len = 0;
            //'('의 개수
            int leftCnt = 0;
            //만약 문자열의 개수가 홀수이면, 모든 조합의 개수는 ㄴㄴ괄호 문자열입니다.
            boolean flag = N % 2 == 1;
            //'(', ')' 조합 진행
            while(len < N){
                //더 이상 괄호 문자열이 존재하지 않을 때
                if(flag){
                    //')'을 사용할 때
                    if(K > combinationCnt[N-len-1]){
                        sb.append(")");
                        K -= combinationCnt[N-len-1];
                    }else{	//'('을 사용할 때
                        sb.append("(");
                    }
                }else{  //괄호 문자열이 존재할 때
                    //')'을 사용할 때
                    if(K > DP[leftCnt+1][N-len-1]){
                        sb.append(")");
                        K -= DP[leftCnt+1][N-len-1];
                        leftCnt--;	//')'을 사용하기 때문에 '('의 개수가 줄어듭니다.
                    }else{ //'('을 사용할 때
                        sb.append("(");
                        leftCnt++; //'('을 사용하기 때문에 '('의 개수가 증가합니다.
                    }
                }
                //')'의 개수가 '('보다 커지면 더 이상 괄호 문자열을 만들 수 없습니다.
                if(!flag && leftCnt < 0 ){
                    flag = true;
                }
                //문자 선택한 길이
                len++;
            }
            //k번째 문자열 BufferedWriter 저장
            bw.write(sb.toString());
        }
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}