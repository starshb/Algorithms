import java.io.*;
import java.util.*;

public class Main {
	static int map[][], N, M, min;
	static boolean visited[][];
	static List<int[]> nodes;
	
	public static void dfs(int x, int y, int n) {
		nodes.add(new int[] {x, y});
		int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(map[nx][ny]!=0) {
				if(map[nx][ny]!=n) {
					min = Math.min(min, map[nx][ny]);
					continue;
				}
				if(visited[nx][ny]) {continue;}
				visited[nx][ny] = true;
				dfs(nx, ny, n);
			}
			else {
				min = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		int result = 0;
		for(int i=1; i<N+1; i++) {
			map[i][0] = 0;
			map[i][M+1] = 0;
			String s = br.readLine();
			for(int j=1; j<M+1; j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		//벽세우기
		for(int i=0; i<M+2; i++) {
			map[0][i] = 0;
			map[N+1][i] = 0;
		}
		
		for(int i=1; i<10; i++) {
			//전체를 돌면서
			for(int j=1; j<N+1; j++) {
				for(int k=1; k<M+1; k++) {
					if(map[j][k]==i && !visited[j][k]) {
						nodes = new LinkedList<>();
						min = 9;//최대 9까지 가능
						visited[j][k] = true;
						dfs(j, k, i);
						if(min>i) {
							int temp = min-i;
							for(int[] pos : nodes) {
								map[pos[0]][pos[1]] = min;
								visited[pos[0]][pos[1]]=false;
								result += temp;
							}
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}