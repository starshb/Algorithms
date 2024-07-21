import java.io.*;
import java.util.*;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

	private static int[] dxs = {1, -1, 0, 0}, dys = {0, 0, -1, 1};

	private static int n, m;
	private static char[][] g;
	private static int[][] dp;
	private static boolean[][] visited;
	private static int ans = 0;



	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		g = new char[n][m];
		dp = new int[n][m];
		visited = new boolean[n][m];


		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String cur = st.nextToken();
			for (int j = 0; j < m; j++) {
				g[i][j] = cur.charAt(j);
				dp[i][j] = 0;
				visited[i][j] = false;
			}
		}

		visited[0][0] = true;
		dfs(0, 0, 1);

		sb.append(ans);
		bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

	static boolean inRange(int x, int y) {
		return 0 <= x && x < m && 0 <= y && y < n;
	}

	static void dfs(int x, int y, int depth) {
		if (ans == -1) return;
        
		ans = Math.max(ans, depth);
		int step = g[y][x] - '0';
		for (int i = 0; i < 4; i++) {
			int nx = x + dxs[i] * step, ny = y + dys[i] * step;
			if (inRange(nx, ny) && g[ny][nx] != 'H' && depth + 1 > dp[ny][nx]) {
				if (visited[ny][nx]){
					ans = -1;
					return;
				} else {
					dp[ny][nx] = depth + 1;
					visited[ny][nx] = true;
					dfs(nx, ny, depth + 1);
					visited[ny][nx] = false;
				}
			}
		}
	}
}