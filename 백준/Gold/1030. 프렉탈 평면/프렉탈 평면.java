import java.io.*;
import java.util.*;

class Main {
    static int s,N,K,R1,R2,C1,C2,sSize;
    static char[][] arr= new char[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        divide(0,0,(int)Math.pow(N,s),false);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=R2-R1; i++){
            for(int j=0; j<=C2-C1; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static void divide(int x, int y, int size, boolean isBlack){
        if(x > C2 || x+size <= C1|| y > R2 || y+size <= R1) return;
        if(size==1){
            arr[y-R1][x-C1] = isBlack? '1': '0';
            return;
        }
        int nSize = size/N;
        int blackStart = (N-K)/2;
        int blackEnd = N-blackStart;
        for(int i=0; i<N; i++){
            int nY = y+nSize*i;
            for(int j=0; j<N; j++){
                int nX = x+nSize*j;
                divide(nX,nY,nSize, isBlack || (i >= blackStart && i < blackEnd) && (j >= blackStart && j < blackEnd));
            }
        }
    }
}
