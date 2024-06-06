	import java.io.*;
import java.util.*;
 
public class Main {
    static int[] map;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        for (int i=0; i<N; i++) {
            ans = Math.max(ans, Count(i));
        }
        
        System.out.println(ans);
    }
    
    public static int Count(int idx) {
        int cnt = 0;
        double tmp = 0;
        
        // 왼쪽
        for (int i=idx-1; i>=0; i--) {
            double slope = (double) (map[idx] - map[i]) / (idx - i);
           
            if (i == idx-1 || tmp > slope) {
                cnt++;
                tmp = slope;
            }
        }
        
        // 오른쪽
        for (int i=idx+1; i<N; i++) {
            double slope = (double) (map[idx] - map[i]) / (idx - i);
            
            if (i == idx+1 || tmp < slope) {
                cnt++;
                tmp = slope;
            }
        }
        
        return cnt;
    }
}