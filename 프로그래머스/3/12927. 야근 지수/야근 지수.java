import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            q.offer(works[i]);
        }
        
        while(n > 0) {
            int work = q.poll();
            if(work == 0) break; //더 이상 줄일 수 있는 일이 없음.
            work -= 1; //일 한시간 줄인다.
            q.offer(work);
            n -= 1; // 남은 작업 시간 한시간 줄인다.
        }
        
        long answer = 0;
        for(int work : q) {
            answer += work * work;
        }
        return answer;
    }
}
