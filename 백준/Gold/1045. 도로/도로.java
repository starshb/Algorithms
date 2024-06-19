import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static char[][] map;
    static int[] roots;
    static Queue<Edge> edges = new LinkedList<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        roots = new int[N];
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            roots[i] = i;
            for (int j = i + 1; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'Y') {
                    edges.add(new Edge(i, j));
                }
            }
        }
    }

    private static void solve() {
        int unionCount = 0;
        int[] count = new int[N];
        if(edges.size() < M) {
            answer.append(-1);
            return;
        }

        Queue<Edge> left = new LinkedList<>();
        while (!edges.isEmpty()) {
            Edge here = edges.poll();
            if (union(here.s, here.e)) {
                count[here.s]++;
                count[here.e]++;
                unionCount++;
            } else {
                left.add(here);
            }
        }
        if (unionCount != N - 1) {
            answer.append(-1);
            return;
        }
        for (int i = N - 1; i < M; i++) {
            if (left.isEmpty()) {
                answer.append(-1);
                return;
            }
            count[left.peek().s]++;
            count[left.peek().e]++;
            left.poll();
        }
        for (int i = 0; i < N; i++) {
            answer.append(count[i]).append(" ");
        }
    }

    private static boolean union(int s, int e) {
        s = find(s);
        e = find(e);

        if(s == e)
            return false;
        else if(s < e)
            roots[e] = s;
        else
            roots[s] = e;
        return true;
    }

    private static int find(int s) {
        if(roots[s] == s)
            return s;
        return roots[s] = find(roots[s]);
    }


    private static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.toString());
        bw.flush();
    }
}

class Edge {
    int s, e;

    public Edge(int s, int e) {
        this.s = s;
        this.e = e;
    }
}