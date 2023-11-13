import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            }
            else {
                answer++;
            }
        }
        
        return answer;
    }
}