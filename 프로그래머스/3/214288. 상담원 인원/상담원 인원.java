import java.util.*;

public class Solution {

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;

        // 타입마다 시간을 분리할 리스트
        List<List<Time>> timeForEachType = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            timeForEachType.add(new ArrayList<>());
        }

        // 1. 유형마다 시간을 분리
        for (int[] req : reqs) {
            int startTime = req[0];
            int duration = req[1];
            int type = req[2];

            timeForEachType.get(type).add(new Time(startTime, startTime + duration));
        }

        // 2. 각 유형[type]마다 1~(n-k)+1 수의 상담사를 배정하고, 상담사 숫자에 따른 각 대기 시간을 구함
        int[][] waitTimeForEachTime = new int[k + 1][n + 1];
        for (int type = 1; type < k + 1; type++) { // 유형

            // 해당 타입의 상담을 신청 지원자가 한 명도 없을 때
            if (timeForEachType.get(type).size() == 0) continue;

            // 상담원을 1 부터 배정
            for (int counselors = 1; counselors <= (n-k)+1; counselors++) {

                // counselorSize만큼 상담원을 가질 때의 대기시간을 구함
                int waitTime = calculationTime(timeForEachType.get(type), counselors);

                // 현재 상담원 인원으로 상담했을 때 대기시간 저장
                waitTimeForEachTime[type][counselors] = waitTime;
            }
        }

        // 3. 우선 각 상담원을 한 명씩 배치
        int[] currentCounselors = new int[k + 1];
        for (int type = 1; type < k + 1; type++) {
            currentCounselors[type] = 1;
        }

        // 각 유형에 한 명씩 배치하고 남은 상담사 수
        int remainCounselorNumber = n - k;

        // 4. 대기시간이 가장 많이 줄어드는 곳에 상담사를 한 명씩 배치한다. -> 그리디
        while (remainCounselorNumber-- > 0) {
            int maxReduceTime = 0; // 상담사 수가 증가했을 때 대기시간이 가장 많이 줄어드는 시간
            int correspondingType = 0; // 해당 타입의 번호

            for (int type = 1; type < k + 1; type++) {
                // 현재 상담원 수
                int currentCounselorsByType = currentCounselors[type];

                // 현재 상담자수일 때의 대기시간
                int waitingTimeOfCurrentCounselors = waitTimeForEachTime[type][currentCounselorsByType];

                // 상담원이 1 늘었을 때의 대기시간
                int next = waitTimeForEachTime[type][currentCounselorsByType + 1];

                // 상담원이 추가되었을 때 줄어드는 대기시간
                int reduceWaitingTime = Math.abs(waitingTimeOfCurrentCounselors - next);

                // 상담사 인원이 추가 되었을 때, 가장 많이 줄어드는 시간과 유형 저장
                if (reduceWaitingTime >= maxReduceTime) {
                    maxReduceTime = reduceWaitingTime;
                    correspondingType = type;
                }
            }

            // 상담원을 증가시켜도 더 이상 줄어들 대기시간이 없을 때
            if (maxReduceTime == 0) break;

            // 가장 긴 대기시간을 가진 것에 상담원 추가
            currentCounselors[correspondingType]++;
        }

        // 5. 상담원 배치가 끝나고 계산
        for (int type = 1; type < k + 1; type++) {

            // 해당 타입의 상담을 신청 지원자가 한 명도 없을 때 -> 계산할 것이 없음
            if (timeForEachType.get(type).size() == 0) continue;

            int counselors = currentCounselors[type];

			// 상담원당 대기시간은 위에서 구해서 저장했으니 그대로 사용
            answer += waitTimeForEachTime[type][counselors];
        }

        return answer;
    }

    private int calculationTime(List<Time> typeTime, int counselorNumber) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝나는 시간 저장
        int waitTime = 0;

        for (Time t : typeTime) { // 해당 타입의 상담 정보들을 가져옴
            if (pq.isEmpty() || pq.size() < counselorNumber) { // 상담원수가 남아 있을 때
                pq.add(t.end);
            } else {
                // 현재 진행중인 상담중 가장 빨리 끝나는 시간
                int earlyConsultEndTime = pq.poll();

                if (t.start < earlyConsultEndTime) { // 대기시간이 있는 경우
                    waitTime += (earlyConsultEndTime - t.start);
                    pq.add(earlyConsultEndTime + (t.end - t.start));
                } else {
                    pq.add(t.end); // 대기시간이 없는 경우 종료시간 저장
                }
            }
        }
        return waitTime;
    }

    private class Time {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}