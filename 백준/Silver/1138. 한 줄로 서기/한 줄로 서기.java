import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] intArr  = new int[N+1];
        int[] answer = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        //i는 intArr[i]번 인덱스를 의미, j는 intArr[i]가 들어갈 자리
        for(int i = 1; i<=N; i++){
            int j = 1;

            while(true) {
                if (intArr[i] == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
                else if(answer[j] == 0)
                    intArr[i]--;

                //answer[j] == 0에도 j++해주는 이유는
                //intArr[i] != 0 && answer[j] == 0일 때 j번 자리는 비어있지만
                //intArr[i]가 0이 아니면 그 왼쪽에 자신보다 큰 수가 와야하기 때문에
                //한 칸 옆으로 이동해준다.
                j++;
            }
        }

        for(int i = 1; i<=N; i++)
            System.out.print(answer[i] +" ");
    }
}