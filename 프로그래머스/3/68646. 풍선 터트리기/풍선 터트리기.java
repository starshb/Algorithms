import java.util.*;
 
class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length]; //각 인덱스에서 왼쪽 원소의 최소값을 저장
        int[] rightMin = new int[a.length]; //각 인덱스에서 오른쪽 원소의 최대값을 저장
        int l = a[0]; //왼쪽 값 중 최소값
        int r = a[a.length - 1]; //오른쪽 값 중 최소값
        
        //i일때 왼쪽 원소의 최소값을 저장
        for(int i = 1; i < a.length - 1; i++) {
            if(l > a[i]) l = a[i];
            leftMin[i] = l;
        }
        //i일때 오른쪽 원소의 최소값을 저장
        for(int i = a.length - 2; i > 0; i--) {
            if(r > a[i]) r = a[i];
            rightMin[i] = r;
        }
        
        if(a.length == 1) return 1; //원소가 1개면 답은 1이다.
        int answer = 2; // 반환할 값. 원소가 2개 이상일때 무조건 2개 이상은 남게된다.
        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }
        return answer;
    }
}