import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[][] arr = new int[N][M];
		final int MIN = Math.min(N, M);
		int area = 0;
		int maxArea = 0;
		
		// 2차원 배열에 값 넣기
		for(int i=0; i<N; i++) {
			String str = scan.next();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<MIN; k++) {
					if(i+k < N && j+k < M) {	// 배열 범위 이내
						
						// 4개의 꼭짓점이 정사각형이 되는 조건
						if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k]) {
							area = (k+1) * (k+1);
							maxArea = Math.max(maxArea, area);
						}
					}
				}
			}
		}
		
		System.out.println(maxArea);
		scan.close();
	}

}