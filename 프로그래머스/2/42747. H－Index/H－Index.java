import java.util.*;
 
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(citations);
 
        for(int i = 0; i < citations.length; i++) {
            // 현재 논문부터 마지막까지의 논문 개수
            int h = citations.length - i;
            
            // h가 현재 논문의 인용된 횟수보다 작거나 같으면
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}