import java.io.*;
import java.util.*;

public class Main {

    public static int[] visited = new int[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N, K;

        Queue<Integer> list = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int length = 0;

        while (N / (int) Math.pow(10, length) != 0) {
            length++;
        }

        // queue에 처음 N 추가
        list.add(N);

        while (!list.isEmpty() && K > 0) {
            int size = list.size();

            for (int x = 0; x < size; x++) {
                int now = list.poll();

                // change
                for (int i = 0; i < length - 1; i++) {
                    for (int j = i + 1; j < length; j++) {
                        int next = swap(now, i, j);

                        // 앞자리가 0이거나 현재 depth에서 방문한 적이 있는 경우 queue에 add하지 않음.
                        if (next != 0 && visited[next]!=K) {
                            list.add(next);
                            visited[next] = K;
                        }
                    }
                }
            }

            K--;
        }

        if (list.isEmpty()) {
            System.out.println("-1");
        } else {

            int ans = 0;

            for (int x : list) {
                ans = Math.max(x, ans);
            }

            System.out.println(ans);
        }


    }

    // 교환
    public static int swap(int now, int i, int j) {


        char[] list = String.valueOf(now).toCharArray();

        char temp = list[i];
        list[i] = list[j];
        list[j] = temp;


        // 앞자리가 0이면 error

        if(list[0]=='0')
            return 0;


        return Integer.parseInt(new String(list));
    }


}
