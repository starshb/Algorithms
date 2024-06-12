import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{


    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


       int N = Integer.parseInt(st.nextToken()); //행
       int M = Integer.parseInt(st.nextToken()); //열

        
        int [] offCount = new int[N]; // 그 행에 몇의 램프가 꺼져있는지 저장할 배열 ->즉 스위치를 눌러야하는 횟수
        String [] line = new String[N]; // 그 행의 램프 상태 => ex )'1010110'
        
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            int zero = 0 ; // 꺼져있는 램프 개수
            for(int j = 0 ; j < M ; j++){
                if(s.charAt(j)=='0'){ //램프가 꺼져있다면
                   zero++;
                }
            }        
            offCount [i]=zero;
            line[i]=s;
        }

      int  K = Integer.parseInt(br.readLine()); // 스위치를 눌러야 하는 횟수
        
        int max = 0; //최소의 경우는 0
        
      
         for(int i = 0 ; i < N; i++){

            
             if(offCount[i]<=K&&(K-offCount[i])%2==0){

                 int equalCount = 1 ; // 현재 i은 켜져있는 행이므로 초기값은 1

                 for(int j = 0 ; j < N;j++){
                     if(i==j)continue; //자기 자신 탐색하는건 넘어간다.
                     if(line[i].equals(line[j])){ // i 행과 같은 상황의 행이 있다면 +1
                         equalCount++;
                     }
                 }

                 max=Math.max(max,equalCount); //최대값 갱신
             }


        }

        System.out.println(max); // 정답 출력

    }

}