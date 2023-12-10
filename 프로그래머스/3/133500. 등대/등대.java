import java.util.*;

class Solution {
    public int N, result = 0;
    public List<List<Integer>> map = new ArrayList<>();

    public int dfs(int cur, int before) {
        //리프 노드일 경우
        if (map.get(cur).size() == 1 && map.get(cur).get(0) == before)
            return 1;

        //리프 노드가 아닐 경우
        int tmpRes = 0;
        for (int i = 0; i < map.get(cur).size(); i++) {
            int next = map.get(cur).get(i);
            if (next == before) continue;
            tmpRes += dfs(next, cur);
        }

		//해당 노드가 불을 킬 필요 없음
		if (tmpRes == 0) 
        	return 1;
        
        //해당 노드가 불을 켜야함
        result++;
        return 0;
    }

    public int solution(int n, int[][] lighthouse) {
        //초기화
        N = n;
        for (int i = 0; i <= N; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < lighthouse.length; i++) {
            map.get(lighthouse[i][0]).add(lighthouse[i][1]);
            map.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }

        //dfs로 켜야하는 등대 개수 판별
        dfs(1, 0);
        return result;
    }
}