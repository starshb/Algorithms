import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++)
            crane.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        //내림차순으로 정렬
        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
            return;
        }

        int day = 0;
        while(!box.isEmpty()){
            int boxIdx = 0, craneIdx = 0;

            while(craneIdx<N){
                if(boxIdx == box.size())
                    break;
                else if(crane.get(craneIdx) >= box.get(boxIdx)){
                    box.remove(boxIdx);
                    craneIdx++;
                }
                else
                    boxIdx++;
            }

            day++;
        }

        System.out.println(day);
    }
}