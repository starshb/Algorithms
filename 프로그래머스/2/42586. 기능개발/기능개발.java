import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        int[] works = new int[progresses.length];
        
      
        for(int i = 0; i < speeds.length; i++){
            works[i]  = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0){
                works[i]  += 1;
            }
        }
        
        int x = works[0];
        int count=1;
        for(int i=1;i<progresses.length;i++){

            if(x>=works[i]){
                count+=1;
            }else{
                list.add(count);
                count =1;
                x= works[i];
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];

        for (int i = 0; i <list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}