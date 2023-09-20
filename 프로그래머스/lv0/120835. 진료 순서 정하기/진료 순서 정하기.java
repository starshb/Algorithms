import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
    	// asc라는 배열을 새로 선언해서 새로운 메모리 공간을 확보하고
        int[] asc = new int[emergency.length];
        int[] answer = new int[emergency.length];
        
        // for돌려서 값 하나하나 넣어준다.
        for(int i=0; i<=emergency.length-1; i++) {
            asc[i]=emergency[i];
        }
        
        Arrays.sort(asc);
        
        for(int i=0; i<=emergency.length-1; i++) {
            for(int j=0; j<=emergency.length-1; j++) {
                if(asc[i]==emergency[j]) {
                    answer[j]=emergency.length-i;
                }
            }
        }
        return answer;
    }
}