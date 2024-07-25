import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.util.StringTokenizer;
 
public class Main {
 
    static int N;
    static boolean[] check;
 
    static int solution() {
        int result = Math.abs(N - 100);
 
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            if (broken(str)) {
                result = Math.min(result, (str.length() + Math.abs(N - i)));
            }
        }
 
        return result;
    }
 
    static boolean broken(String str) {
        for (int j = 0; j < str.length(); j++) {
            if (check[str.charAt(j) - '0']) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
 
        if (n == 0) {
            int result = Math.abs(N - 100);
            result = Math.min(result, (String.valueOf(N).length()));
            System.out.println(result);
        } else {
            st = new StringTokenizer(br.readLine());
 
            check = new boolean[10];
 
            for (int i = 0; i < n; i++) check[Integer.parseInt(st.nextToken())] = true;
 
            System.out.println(solution());
        }
    }
}