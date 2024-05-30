import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 백준 전체 1020 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/08/24/a1020">1020 풀이</a>
 * @since 2021.07.06 11:36:34
 */
public class Main
{
	// 숫자 선분 갯수
	private static final int[] FLAG = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 5 };
	
	// 메모이제이션 배열
	private static long[][] dp;
	
	// 입력 숫자
	private static long number;
	
	// 자리별로 분리된 숫자 배열
	private static int[] numbers;
	
	// 숫자 자릿수
	private static int N;
	
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
		
		// 입력값
		String input = reader.readLine();
		
		number = Long.parseLong(input);
		
		numbers = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
		
		N = numbers.length;
		
		putDP();
		
		long result = solve();
		
		writer.write(String.valueOf(result));
		writer.newLine();
		writer.flush();
		
		writer.close();
		reader.close();
	}
	
	/**
	 * DP 채우기 함수
	 */
	private static void putDP()
	{
		dp = new long[N + 1][(N * 7) + 1];
		
		// 전체 배열을 long의 최대값으로 초기화
		for (long[] arr : dp)
		{
			Arrays.fill(arr, Long.MAX_VALUE);
		}
		
		// 초기값 설정
		for (int i = 0; i < FLAG.length; i++)
		{
			dp[1][FLAG[i]] = Math.min(dp[1][FLAG[i]], i);
		}
		
		// 배열 채우기
		for (int n = 2; n < dp.length; n++)
		{
			for (int i = 2; i < 8; i++)
			{
				int start = (n - 1) * 2;
				int end = (n - 1) * 7 + 1;
				
				for (int j = start; j < end; j++)
				{
					dp[n][i + j] = Math.min(dp[n][i + j], dp[n - 1][j] + (long) Math.pow(10, n - 1) * dp[1][i]);
				}
			}
		}
	}
	
	/**
	 * 알고리즘 동작 함수
	 *
	 * @return [long] 동일한 선분의 갯수를 가지는 숫자가 나오기까지 걸리는 시간
	 */
	private static long solve()
	{
		// 결과
		long result = (long) Math.pow(10, N);
		
		// 1의 자리 숫자만 비교
		for (int num = 0; num < 10; num++)
		{
			// 입력된 숫자의 1의 자리값
			int units = numbers[N - 1];
			
			// 1의 자리 숫자와 다른 숫자이면서 선분의 갯수는 동일할 경우
			if (FLAG[units] == FLAG[num] && units != num)
			{
				// num이 1의 자리 숫자보다 클 경우
				if (num > units)
				{
					result = Math.min(result, num - units);
				}
				
				// num이 1의 자리 숫자보다 작을 경우
				else
				{
					result = Math.min(result, (long) Math.pow(10, N) + num - units);
				}
			}
		}
		
		// 비교할 선분의 갯수 (1의 자리를 위에서 이미 비교했으므로 1의 자리에 해당하는 선분값을 초기값으로 지정)
		int count = FLAG[numbers[N - 1]];
		
		// (10^i)의 자리 숫자부터 하나씩 비교
		for (int i = 2; i < N + 1; i++)
		{
			// (10^i-1)의 자리까지만 표기한 수
			long digit = number % (long) Math.pow(10, i);
			
			// (10^i)의 자릿수 선분 갯수 누적
			count += FLAG[numbers[N - i]];
			
			// (10^i)의 자릿수에 0 ~ 9를 대입하여 비교
			for (int num = 0; num < 10; num++)
			{
				// 비교할 선분의 갯수와 현재 숫자의 선분의 갯수차가 양수일 경우
				if (count - FLAG[num] >= 0)
				{
					// (10^i-1)의 자릿수에 현재 숫자를 곱한 수
					long pows = (long) Math.pow(10, i - 1) * num;
					
					// i-1 자리에서 선분의 합이 (count - FLAG[num])이 되는 가장 작은 수
					long target = dp[i - 1][count - FLAG[num]];
					
					// pows와 target의 합이 digit과 다르며, 유효한 값을 가지는 메모이제이션 배열일 경우
					if (digit != pows + target && target != Long.MAX_VALUE)
					{
						long val = pows + target - digit;
						
						// 계산한 값이 음수일 경우
						if (val <= 0)
						{
							// 10^N 자리를 넘어가므로 한 주기를 돌아 다시 카운팅해야한다.
							val += (long) Math.pow(10, N);
						}
						
						result = Math.min(result, val);
					}
				}
			}
		}
		
		return result;
	}
}