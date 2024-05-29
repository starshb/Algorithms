import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 전체 1019 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/06/28/a1019">1019 풀이</a>
 * @since 2021.06.28 Mon 12:28:50
 */
public class Main
{
	// 숫자 카운트 배열
	private static final int[] COUNTER = new int[10];
	
	/**
	 * 메인 함수
	 *
	 * @param args: [String[]] 매개변수
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 마지막 페이지
		int N = Integer.parseInt(reader.readLine());
		
		solve(N);
		
		StringBuilder builder = new StringBuilder();
		
		for (int item : COUNTER)
		{
			builder.append(item).append(" ");
		}
		
		writer.write(builder.toString().trim());
		writer.newLine();
		writer.flush();
		
		reader.close();
		writer.close();
	}
	
	/**
	 * 알고리즘 동작 함수
	 *
	 * @param num: [int] 마지막 페이지
	 */
	private static void solve(int num)
	{
		// 시작 페이지
		int start = 1;
		
		// 자릿수
		int digit = 1;
		
		while (start <= num)
		{
			// 1의 자리가 9가 될 때까지 마지막 페이지를 1씩 감소함
			while (num % 10 != 9 && start <= num)
			{
				// 감소한 페이지 별도 카운팅
				count(num, digit);
				
				num--;
			}
			
			// 마지막 페이지가 시작 페이지보다 작을 경우
			if (num < start)
			{
				// 이를 처리하지 않으면 num < 9일 경우 무한루프를 탐
				break;
			}
			
			// 1의 자리가 0이 될 때까지 시작 페이지를 1씩 증가함
			while (start % 10 != 0 && start <= num)
			{
				// 증가한 페이지 별도 카운팅
				count(start, digit);
				
				start++;
			}
			
			start /= 10;
			num /= 10;
			
			for (int i = 0; i < 10; i++)
			{
				COUNTER[i] += (num - start + 1) * digit;
			}
			
			// 자릿수 증가
			digit *= 10;
		}
	}
	
	/**
	 * 카운트 함수
	 *
	 * @param num: [int] 대상 숫자
	 * @param digit: [int] 자릿수
	 */
	private static void count(int num, int digit)
	{
		while (num > 0)
		{
			COUNTER[num % 10] += digit;
			num /= 10;
		}
	}
}