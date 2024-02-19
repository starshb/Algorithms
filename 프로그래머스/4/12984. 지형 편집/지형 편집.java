import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    int[] land_1d ;
    int n ;
    int myP, myQ;
    ArrayList<Long> answer;
    public long solution(int[][] land, int P, int Q) {
        n = land.length;
        myP = P;
        myQ = Q;
        land_1d = new int[n*n];
        answer = new ArrayList<Long>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
               land_1d[i*n+j] = land[i][j];
        Arrays.sort(land_1d);
        int maxh = land_1d[n*n-1];
        int minh = land_1d[0];

        int left = minh;
        int right = maxh;
        int x = (left+right)/2;
        while(left < right){
            if(func(x) < func(x+1)){
                right = x;
            } else  {
                left = x+1;
            }
            x = (left+right)/2;
        }

        return func(x);
    }
    public long func(long t){ // long t vs int t에 따라 결과가 달라집니다
        long result = 0;
        for(int a : land_1d){
            result += (long)((t-a) >= 0 ? (t-a)*myP : (a-t)*myQ);
        }

        return result;
    }

}