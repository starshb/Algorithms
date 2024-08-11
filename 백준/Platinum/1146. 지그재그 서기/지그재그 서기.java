import java.util.Scanner;

public class Main {
    final static int R = 1_000_000;

    static long[][] dp1;
    static long[][] dp2;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        dp1 = new long[n][n];
        dp2 = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp1[i][j] = dp2[i][j] = -1;
            }
        }

        dp1[1][0] = 1;
        dp1[1][1] = 1;
        dp1[1][2] = 1;
        dp2[0][1] = 1;
        dp2[1][1] = 1;
        dp2[2][1] = 1;

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += f1(n - 1 - i, i) + f2(n - 1 - i, i);
            sum %= R;
        }
        System.out.println(sum);
    }

    static long f1(int greater, int smaller) { // ASC
        if (dp1[greater][smaller] != -1) return dp1[greater][smaller];
        if (greater == 0) return 0;

        long sum = 0;
        for (int i = 0; i < greater; i++) {
            sum += f2(greater - 1 - i, smaller + i);
            sum %= R;
        }

        return dp1[greater][smaller] = sum;
    }

    static long f2(int greater, int smaller) { // DSC
        if (dp2[greater][smaller] != -1) return dp2[greater][smaller];
        if (smaller == 0) return 0;

        long sum = 0;
        for (int i = 0; i < smaller; i++) {
            sum += f1(smaller + greater - 1 - i, i);
            sum %= R;
        }

        return dp2[greater][smaller] = sum;
    }
}