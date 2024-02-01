import java.util.*;

class Solution {
    public int N;
    public int[] C;
    public int INF = 987654321;

    // INF : t 늘려야함
    // 0 : 해당 시간이 맞음
    // -INF : t 줄여야함
    public int check(int t) {
        //나머지가 0인 코어 번호 리스트
        List<Integer> zeroList = new ArrayList<>();

        //해당 시간에 들어가 있는 작업 갯수
        int insertCnt = 0;

        for (int i = 0; i < C.length; i++) {
            insertCnt += (t / C[i] + 1);
            if (t % C[i] == 0)
                zeroList.add(i + 1);
        }

        if (insertCnt < N) return INF;
        else if (N <= insertCnt - zeroList.size()) return -INF;
        //마지막 작업 코어 번호 리턴
        else {
            return zeroList.get(N - (insertCnt - zeroList.size()) - 1);
        }
    }

    public int solution(int n, int[] cores) {
        //초기화
        N = n;
        C = cores;
        int maxT = 0;
        for (int i = 0; i < C.length; i++)
            maxT = Math.max(maxT, C[i]);

        //이분 탐색 진행
        int hi = N * maxT / C.length + 1;
        int lo = 0;

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int res = check(mid);

            if (res == INF) lo = mid;
            else if (res == -INF) hi = mid;
            else return res;
        }
        return 0;
    }
}