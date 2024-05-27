import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 백준 전체 1016 문제 알고리즘 클래스
 *
 * @author RWB
 * @see <a href="https://blog.itcode.dev/posts/2021/06/23/a1016">1016 풀이</a>
 * @since 2021.06.23 Fri 00:22:31
 */
public class Main
{
	// 최소값
	private static long min;
	
	// 최대값
	private static long max;
	
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
		
		long[] temp = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		min = temp[0];
		max = temp[1];
		
		writer.write(Integer.toString(solve()));
		writer.newLine();
		
		writer.close();
		reader.close();
	}
	
	/**
	 * 알고리즘 결과 반환 함수
	 *
	 * @return [int] 제곱수로 나누어 떨어지지 않는 수의 갯수
	 */
	private static int solve()
	{
		int size = 0;
		
		boolean[] isNotPow = eratosthenes();
		
		for (boolean item : isNotPow)
		{
			// 제곱수로 나누어 떨어지지 않는 수일 경우
			if (!item)
			{
				size++;
			}
		}
		
		return size;
	}
	
	/**
	 * 에라토스 테네스의 체 배열 반환 함수
	 * true: 제곱ㄴㄴ수가 아닌 수
	 * false: 제곱ㄴㄴ수
	 *
	 * @return [boolean[]] 에라토스 테네스의 체 배열
	 */
	private static boolean[] eratosthenes()
	{
		int length = (int) (max - min + 1);
		
		boolean[] isNotPow = new boolean[length];
		
		for (long i = 2; i * i <= max; i++)
		{
			long pow = i * i;
			
			long start = min % pow == 0 ? min / pow : (min / pow) + 1;
			
			for (long j = start; j * pow <= max; j++)
			{
				// 제곱수의 배수로 나누어 떨어지므로 제곱ㄴㄴ수가 아님
				isNotPow[(int) (j * pow - min)] = true;
			}
		}
		
		return isNotPow;
	}
}