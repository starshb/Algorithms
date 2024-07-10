import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int count = 0;
		//막대기
		int[] arr = {64, 32, 16, 8, 4, 2, 1};
		int sum = 0;
		
		//막대기는 총 7개이니 7번 반복하는 반복문
		for(int i = 0; i < 7; i++) {
			//원하는 값보다 작은 값들로만 연산한다.
			if(arr[i] <= X) {
				sum += arr[i];
				count++;
			}
			//더했는데 원하는 값보다 길면 빼준다. 뺐기때문에 개수에서도 빼준다.
			if(sum > X) {
				sum -= arr[i];
				count--;
			}
			//같아지면 반복문을 종료하고 개수를 출력한다.
			if(sum == X) break;
		}
		System.out.println(count);
	}

}