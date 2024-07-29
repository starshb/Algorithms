import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준알고리즘 1120번 문자열

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int result = A.length();

        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int tmp = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    tmp++;
                }
            }
            if (result > tmp) {
                result = tmp;
            }
        }
        System.out.println(result);
    }
}