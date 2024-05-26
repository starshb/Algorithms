import java.io.*;
import java.util.*;

public class Main
{
   
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 배열의 크기
        int N = Integer.parseInt(br.readLine());

        // 원본 배열
        int[][] A = new int[N][2];

        // 정렬 배열
        int[] B = new int[N];

        String[] temp = br.readLine().split(" ");


        for (int i = 0; i < N; i++)
        {
            A[i][0] = Integer.parseInt(temp[i]);
            A[i][1] = i;
        }

        // 정렬 수행
        sort(A);

        for (int i = 0; i < N; i++)
        {
            int index = A[i][1];

            B[index] = i;
        }

        for (int b : B)
        {
            sb.append(b).append(" ");
        }

        System.out.println(sb.toString().trim());

        bw.close();
        br.close();
    }

    private static void sort(int[][] A)
    {
        Arrays.sort(A, (next, current) ->
        {
            //현재값이 더 클 경우
            if (next[0] < current[0]) return -1;

            // 다음값이 더 클 경우
            else if (next[0] > current[0]) return 1;

            // 현재값과 다음값이 같을 경우, 사전순 정렬
            else return Integer.compare(next[1], current[1]);
        });
    }
}