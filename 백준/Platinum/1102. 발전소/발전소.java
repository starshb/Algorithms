import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.logging.XMLFormatter;

public class Main {

    public static int num;
    public static int[][] cost;
    public static int P;
    public static int[] dp;
    public static int MAX = 1000;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());

        cost = new int[num][num];

        dp = new int[1 << num];


        for (int x = 0; x < num; x++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int y = 0; y < num; y++) {
                cost[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < (1 << num); x++) {
            dp[x] = -1;
        }

        String status = br.readLine();

        P = Integer.parseInt(br.readLine());

        int bit = 0;
        int on = 0;

        for (int x = 0; x < num; x++) {
            if (status.charAt(x) == 'Y') {
                bit |= 1 << x;
                on++;
            }
        }

        int ans = onFactory(bit, on);


        if (ans == MAX) {
            ans = -1;
        }

        bw.write(String.valueOf(ans));
        bw.flush();


    }

    public static int onFactory(int bit, int onNum) {
        if (onNum >= P) {
            return 0;
        }

        if (dp[bit] != -1) {
            return dp[bit];
        }


        int ret = MAX;

        for (int x = 0; x < num; x++) {
            if ((bit & (1 << x)) == 0) {

                int nextbit = bit | (1 << x);

                int min = MAX;

                for (int y = 0; y < num; y++) {
                    if ((bit & (1 << y)) != 0) {
                        min = Math.min(min, cost[y][x]);
                    }
                }

                ret = Math.min(ret, onFactory(nextbit, onNum + 1) + min);
            }
        }

        dp[bit] = ret;

        return ret;
    }

}
