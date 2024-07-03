import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 처음에 n의 끝자리 두개는 00으로 만들어준다
        n /= 100;
        n *= 100;
        int f = Integer.parseInt(br.readLine());
        int ans = 0;
        //n이 f로 나누어지지 않으면 계속 더해준다
        while (n % f != 0) {
            n++;
            ans++;
        }
        if (ans < 10) {
            System.out.print("0" + ans);
        } else {
            System.out.print(ans);
        }
    }
}