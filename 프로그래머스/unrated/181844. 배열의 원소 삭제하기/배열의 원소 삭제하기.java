import java.util.*;

class Solution {
    public List solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for (int num : arr) {
            answer.add(num);
        }
        
        for(int del : delete_list){
            int index = answer.indexOf(del);
            
            if (index != -1) {
                answer.remove(index);
            }
        }
        
        return answer;
    }
}