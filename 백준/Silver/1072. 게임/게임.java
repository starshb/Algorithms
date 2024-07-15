import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long X, Y;

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if (Z >= 99) {
            bw.write("-1");
        } else {

            long start = 0;
            long end = 2000000000;

            while (start < end) {
                long mid = (start + end) / 2;

                long ret = 100 * (Y + mid) / (X + mid);

                if (ret> Z) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            bw.write(String.valueOf(end));
        }


        bw.flush();

    }




}
