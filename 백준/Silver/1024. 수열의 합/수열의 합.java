import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] sArr = br.readLine().split(" ");
        long N = Long.valueOf(sArr[0]);
        long L = Long.valueOf(sArr[1]);
        boolean flag = true;
    
        while(L <= 100){
            long start = N / L - (L - 1) / 2;
            if(start < 0)
                break;
                
            if(N == (start * 2 + L - 1) * L / 2){
                for(long i = 0; i < L; i++)
                    bw.write(start + i + " ");
                flag = false;
                break;
            }
            
            L += 1;
        }
        
        if(flag)
            bw.write("-1");
            
        bw.write("\n");
        bw.flush();
    }
}
