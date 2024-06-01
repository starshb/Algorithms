import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		int size = (c2 - c1 + 1) * (r2 - r1 + 1);
		int[][] arr = new int[r2 - r1 + 1][c2 - c1 + 1];
		
		int x = 0, y = 0;
		if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
			arr[x - r1][y - c1] = 1;
			size--;
		}
		int state = 0;
		int i = 1;
		int max = 1;
		int count = 0;
		int k = 2;
		int[] disx = {0, -1, 0, 1};
		int[] disy = {1, 0, -1, 0};
		while (size > 0) {
			for (int j = 0; j < i; j++) {
				x += disx[state];
				y += disy[state];
				if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
					arr[x - r1][y - c1] = k;
					size--;
					max = k;
				}
				k++;
			}
			state++;
			count++;
			if (state == 4) {
				state = 0;
			}
			if (count == 2) {
				count = 0;
				i++;
			}
		}
		
		k = 1;
		for (; max >= 10; k++) {
			max /= 10;
		}
		for (i = 0; i <= r2 - r1; i++) {
			for (int j = 0; j <= c2 - c1; j++) {
				
				System.out.format("%" + k + "d ", arr[i][j]);
			}
			System.out.println();
		}
		
	}
	

}