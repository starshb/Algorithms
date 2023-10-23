import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int count = 0;
        int number = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                count++;
            }
        }
        
        if(count == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[count];
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[number] = arr[i];
                number++;
            }
        }
        
        Arrays.sort(answer);
        return answer;
        
    }
}