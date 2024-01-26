class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        // 순번 지정
        int location = 1;
        int stationsLocation = 0;
        
        while(location <= n) {
            // 하나씩 순회하며 수행
            
            if(stationsLocation < stations.length && stations[stationsLocation] - w  <= location) {
                // 만약 기존에 설치된 기지국의 영향권 안일 경우 해당 영향권 바로 다음칸까지 이동
                location = stations[stationsLocation] + w + 1;
                stationsLocation++;
            }
            else {
                // 기존 기지국 영향권 밖일 경우 설치를 하는데, 가능하면 현재위치가 영향권에 드는 가장 오른쪽에 설치
                // 겹치거나 그런건 상관 없음. 그냥 무조건 가장 오른쪽에 설치하면 됨.
                answer++;
                location += 2*w + 1;
            }
        }
        
        return answer;
    }
}