import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		//n값보다 큰 수들중 제일 작은 수를 저장 할 변수
		int high = 1000;
		//n값보다 작은 수들중 제일 큰 수를 저장 할 변수
		int low = 0;
		//n과 num이 같은지 판단 할 변수
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			//n과 num이 같다면 count에 1을 더하고 반복문 종료
			if(num == n) {
				count++;
				break;
			}
			
			//n 기준 제일 가까운 수들을 뽑을 조건 문
			if(num < n && low < num) low = num;

			if(num > n && high > num) high = num;
		}
		//조합의 개수를 저장 할 변수
		int result = 0;
		//count가 1이면 n과 num이 같다는 뜻이니 0 출력
		if(count == 1) {
			System.out.println(0);
		}else {
			//풀이 방법에서 말한 조합 개수를 구하는 반복문
			for(int i = (low + 1); i <= n; i++) {
				for(int j = n; j < high; j++) {
					result++;
				}
			}
			//[n,n]이 있기때문에 -1해서 출력
			System.out.println((result - 1));
		}
	}

}