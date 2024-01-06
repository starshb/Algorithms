class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
      	// 징검다리를 건너는 친구의 최소 수
        int min = 1; 
        // 징검다리를 건너는 친구의 최대 수
        int max = 200000000;
	      
        // 이분탐색 할 기준 : 징검다리는 건널 수 있는 친구의 수
        while (min <= max) {
          	// 징검다리를 건널 인원
            int mid = (min + max) / 2;
            
            // 징검다리 건널 수 있는지 확인
            if (canAcrossRiver(stones, k, mid)) {
              	// 다리를 건널 수 있으면 더 많은 친구들이 가능한지 친구의 수를 넓힘
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                // 다리를 건널 수 없으면 친구의 수를 좁힘
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean canAcrossRiver(int[] stones, int k, int friends) {
        // 못 건너는 징검다리의 개수를 저장
      	int skip = 0;
        
        for (int stone : stones) {
            // 디딤돌의 숫자 - 건너는 친구의 수
            if (stone - friends < 0)
              	// 0보다 작으면 건널 수 없음을 의미
                skip++;
            else
              	// 0 이상이면 건널 수 있음의 의미 = 이 지점에 위치하면 다음으로 갈 수 있음
                // 다시 0으로 갱신
                skip = 0;
            
            // 못 건너는 징검다리의 수가 최대칸 k를 넘으면 해당 값은 건널 수 없음을 의히
            if (skip == k)
                return false;
        }
        
        return true;
    }
}