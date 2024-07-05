import java.io.*;
import java.util.*;

public class Main {
    static int n = 0;
    static int[] number = new int[51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++)
        {
            int num = Integer.parseInt(st.nextToken());

            number[i] = num;
        }

        Arrays.sort(number,0,n); // 오름차순으로 배열 정렬

        for(int i=0;i<n-1;i++)
        {
            boolean kiss = false; // 뒤에 더이상 바꿀 숫자가 없는 경우
            if(number[i]+1==number[i+1]) // 문제 조건에 부합하는 경우
            {
                for (int j = i + 2; j < n; j++) {
                        // 바꿀 숫자를 찾은 경우
                        if (number[i + 1] != number[j]) {
                            kiss = true; // 바꿀 숫자 존재 !
                            swap(i + 1, j); // 위치 교환
                            break; // 사전순으로 낮은 순서부터임
                        }
                 }
                
                // 바꿀 숫자가 존재하지 않는 경우
                if(!kiss)
                {
                    int tmp = 0;
                    for(int k=i-1;k>=0;k--)
                    {
                        if(number[k]!=number[i]) // 작은 숫자가 여러개일 수 있기 때문에 처음 위치 찾기
                        {
                            tmp = k+1;
                            break;
                        }
                    }
                    swap(tmp,i+1); // 처음 위치와 교환
                }
            }
        }

        print();

        br.close();
    }

    // 숫자 배열의 i번째 인덱스의 숫자와 j번째 위치의 숫자를 교환
    static void swap(int i,int j)
    {
        int tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }

    static void print()
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(number[i]+" ");
        }
        System.out.println();
    }
}