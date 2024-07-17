import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        int[] xarr = new int[N];
        int[] yarr = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            arr[i][0] = y;
            arr[i][1] = x;
            yarr[i] = y;
            xarr[i] = x;
        }

        int[] ansarr = new int[N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cury = yarr[i];
                int curx = xarr[j];

                int[] darr = new int[N];
                for(int k = 0; k < N; k++){
                    int diff = Math.abs(cury-arr[k][0])+Math.abs(curx-arr[k][1]);
//                    System.out.println("현재 y x diff : "+cury+" "+curx+" "+diff);
                    darr[k] = diff;
                }
                Arrays.sort(darr);
                for(int k = 1; k < N; k++){
                    darr[k] = darr[k] + darr[k-1];
                }

                if(i==0 && j==0){
                    for(int k = 0; k < N; k++){
                        ansarr[k] = darr[k];
                    }
                }
                for(int k = 0; k < N; k++){
                    if(ansarr[k]>darr[k]) ansarr[k]=darr[k];
                }

            }
        }

        for(int k = 0; k < N; k++){
            System.out.print(ansarr[k] + " ");
        }

//        System.out.println(Arrays.toString(arr));
//            System.out.println("#"+test_case+" "+ans);




    }
}