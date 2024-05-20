import java.util.Scanner;
 
public class Main {
	
	static int[][] dp = new int[30][30];
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < T; i++) {
			
			// M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N이다.
			int N = in.nextInt();	// N = r
			int M = in.nextInt();	// M = n
						
			sb.append(combi(M, N)).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static int combi(int n, int r) {
		
		// 이미 풀린 경우 바로 반환
		if(dp[n][r] > 0) {
			return dp[n][r]; 
		}
		
		// 2번 성질
		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}
		
		// 1번 성질
		return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}
}