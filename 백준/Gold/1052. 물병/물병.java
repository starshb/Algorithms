import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0, index = -1;
        String bitN = Integer.toBinaryString(N);	//N ▶ 2진
        int ones = Integer.bitCount(N);	//2진수 1의 개수
        if(ones > K){	//1의 개수 > K 일 때
            //K번째 '1'을 기준으로 만들어야 하는 형태의 위치 구하기
            for (int i = 0; i < bitN.length(); i++) {
                if (K == 0) {
                    index = i;
                    break;
                }
                if (bitN.charAt(i) == '1')
                    K--;
            }
            String temp = bitN.substring(index);	//바꿔야 하는 값
            int t = Integer.parseInt(temp, 2);	//바꿔야 하는 값의 10진수 값
            /*
            바꿔야 하는 값이 0이 아닐 때
            Math.pow(2, bitN.length() - index) : 만들어야 하는 형태의 10진수 값
            t : 바꿔야 하는 값에 10진수 값
            Math.pow(2, bitN.length() - index) - t : 물병을 사야하는 개수
            */
            if (t != 0)
                answer = (int) (Math.pow(2, bitN.length() - index) - t);
        }
        bw.write(answer + "");		//물병 구매 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}