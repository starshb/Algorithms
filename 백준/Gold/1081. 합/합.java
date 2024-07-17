import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String n = st.nextToken();
		String m = st.nextToken();
		long temp = page(m)-page(n);
		for (int i = 0; i < n.length(); i++)temp+=n.charAt(i)-'0';
		System.out.println(temp);
	}
	
	static long page(String N) {
		long returnVal=0;
		long[]page = new long[10];
		long[]prev = new long[10];
		long[]ans = new long[10];

		int len = N.length();
		
		ArrayList<long[]>index=new ArrayList<>();
		index.add(page.clone());
		long cnt=1;
		//전처리
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j <= 9; j++) {
				page[j]*=10;
				page[j]+=cnt;
			}
			index.add(page.clone());
			cnt*=10;
		}
		
		//0번 자리부터
		for (int i = 0; i < N.length(); i++, len--) {
			int cur = N.charAt(i)-'0';

			long[] curIdx = index.get(len-1);
			long repeat = (long)Math.pow(10, len-1);
			for (int j = 0; j <= 9; j++) {
				ans[j]+=curIdx[j]*cur;
				ans[j]+=prev[j]*repeat*cur;//prev처리
			}
			
			//가장 앞자리 처리
			for (int j = 0; j < cur; j++) {
				ans[j]+=repeat;
			}
			
			prev[cur]++;
		}
		for (int j = 0; j <= 9; j++) ans[j]+=prev[j];
		for (int i = 0; i < N.length(); i++) ans[0]-=Math.pow(10, i);
		for (int i = 0; i <= 9; i++) {
			returnVal+=i*ans[i];
		}
		return returnVal;
	}
	
	
	static int pint(String s) {
		return Integer.parseInt(s);
	}
}