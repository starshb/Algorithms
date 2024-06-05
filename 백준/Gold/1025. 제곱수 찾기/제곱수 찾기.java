import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = -1;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for(int x = 1 - n; x < n; x++){ // 차수
            for(int y = 1 - m; y < m; y++){
                if(x == 0 && y == 0){
                    continue;
                } else {
                    for(int i = 0; i < n; i++){
                        for(int j = 0; j < m; j++){
                            int num = 0, x2 = i, y2 = j;
                            while(x2 >= 0 && y2 >= 0 && x2 < n && y2 < m){
                                num *= 10;
                                num += arr[x2][y2];
                                x2 += x;
                                y2 += y;
                                int num2 = (int)Math.sqrt(num);
                                if(num2 * num2 == num){
                                    ans = Math.max(ans, num);
                                }
                            }
                        }
                    }            
                }
            }
        }
        
        if(ans < 9){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 9){
                        ans = 9;
                    } else if(arr[i][j] == 4 && ans < 4){
                        ans = 4;
                    } else if(arr[i][j] == 1 && ans < 1){
                        ans = 1;
                    } else if(arr[i][j] == 0){
                        ans = 0;
                    } 
                }
            }
        }
        bw.write(Integer.toString(ans));
        br.close();
        bw.close();
    }
}