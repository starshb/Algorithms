import java.util.*;

class Solution {

    //특정 시간이 주어졌을 떄, (a, b)만큼 조달이 가능한지 리턴
    //가능하면 ture
    //불가능하면 false
    public boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        int n = g.length;
        long total = 0L;
        long totalG = 0L;
        long totalS = 0L;

        for (int i = 0; i < n; i++) {
            //해당 시간에 옮길 수 있는 횟수
            long cnt = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i]) cnt++;

            //해당 시간에 옮길 수 있는 무게
            long tmp = Math.min(cnt * w[i], g[i] + s[i]);
            //각 도시의 총합 최대 무게 누적
            total += tmp;
            //각 도시의 금 최대 무게 누적
            totalG += Math.min(tmp, g[i]);
            //각 도시의 은 최대 무게 누적
            totalS += Math.min(tmp, s[i]);
        }

        if (total >= a+b && totalG >= a && totalS >= b) return true;
        return false;
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long hi = 400000000000000L;
        long lo = 0;

        //이분 탐색
        while(lo + 1 < hi) {
            long mid = (lo + hi) / (long)2;

            if (isPossible(mid, a, b, g, s, w, t)) hi = mid;
            else lo = mid;
        }
        return hi;
    }
}